package com.example.Book_My_Show.Services;


import com.example.Book_My_Show.Convertors.TicketConvertor;
import com.example.Book_My_Show.EntryDTOs.TicketEntryDto;
import com.example.Book_My_Show.Models.Show;
import com.example.Book_My_Show.Models.ShowSeats;
import com.example.Book_My_Show.Models.Tickets;
import com.example.Book_My_Show.Models.User;
import com.example.Book_My_Show.Repositories.ShowRepository;
import com.example.Book_My_Show.Repositories.TicketRepository;
import com.example.Book_My_Show.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TicketService {

 @Autowired
    TicketRepository ticketRepository;

 @Autowired
    ShowRepository showRepository;

 @Autowired
    UserRepository userRepository;


 public String bookTicket(TicketEntryDto ticketEntryDto) throws Exception{

     //create Ticket entity by converting from ticket dto
     Tickets tickets = TicketConvertor.ticketDtoToEntity(ticketEntryDto);


     //I need to do a validation ---> whether the requested seats are available or not
     boolean isValidRequestedSeats = checkRequestedSeats(ticketEntryDto);

     if(!isValidRequestedSeats){
         throw new Exception("Requested seats are not available");
     }

     //calculate the total amount


     Show show = showRepository.findById(ticketEntryDto.getShowId()).get();
     List<ShowSeats> showSeatsList = show.getShowSeatsList();
     List<String> requestedSeats = ticketEntryDto.getRequestedSeat();

     int totalAmount = 0;
     for (ShowSeats showSeats : showSeatsList) {
         if (requestedSeats.contains(showSeats.getSeatNo())) {
             totalAmount = totalAmount + showSeats.getPrice();
             showSeats.setBooked(true);
             showSeats.setBookedTime(new Date());
         }
     }
     tickets.setTotalAmount(totalAmount);

     //Setting other attributes
     tickets.setMovieName(show.getMovie().getName());
     tickets.setShowTime(show.getShowTime());
     tickets.setShowDate(show.getShowDate());
     tickets.setTheatreName(show.getTheatre().getName());

     String allottedSeats = getAllottedSeatsForShow(requestedSeats);
     tickets.setBookedSeats(allottedSeats);



     //setting foreign key attributes

     User user = userRepository.findById(ticketEntryDto.getUserId()).get();
     tickets.setUser(user);
     tickets.setShow(show);

     tickets = ticketRepository.save(tickets);

     List<Tickets> ticketsList = show.getListOfBookedTickets();
     ticketsList.add(tickets);
     show.setListOfBookedTickets(ticketsList);

     showRepository.save(show);

     List<Tickets> ticketsList1 = user.getTicketsList();
     ticketsList1.add(tickets);
     user.setTicketsList(ticketsList1);

     userRepository.save(user);

//     String body = "Hi this is to confirm your booking for seat No "+allotedSeats +"for the movie : " + ticketEntity.getMovieName();
//
//
//     MimeMessage mimeMessage=javaMailSender.createMimeMessage();
//     MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
//     mimeMessageHelper.setFrom("backeendacciojob@gmail.com");
//     mimeMessageHelper.setTo(userEntity.getEmail());
//     mimeMessageHelper.setText(body);
//     mimeMessageHelper.setSubject("Confirming your booked Ticket");
//
//     javaMailSender.send(mimeMessage);



     return "Tickets has been successfully generated";

 }

 private String getAllottedSeatsForShow(List<String>  requestedSeats){

     String res = "";
     for(String seat : requestedSeats){
         res = res + seat + ",";
     }
     return res;
 }

 private boolean checkRequestedSeats(TicketEntryDto ticketEntryDto){

     //In order to check whether seats are present, we need to have show-seatslist



     List<String> requestedSeats = ticketEntryDto.getRequestedSeat();

     int showId = ticketEntryDto.getShowId();
     System.out.println(showId);
     Show show = showRepository.findById(showId).get();



     List<ShowSeats> showSeatsList = show.getShowSeatsList();

     //Now I got the showseatsList, now I need to check whether the required seats are present in the list or not
     for(ShowSeats showSeats : showSeatsList){

         String seatNo = showSeats.getSeatNo();
         //I am fetching the seatNo of the show seat and checking if it is present in requiredseat
         if(requestedSeats.contains(seatNo)){
            if(showSeats.isBooked()){
                return false;
            }
         }
     }
     return true;
 }

 public String cancelTicket(int ticketId){
     Tickets tickets = ticketRepository.findById(ticketId).get();

     ticketRepository.delete(tickets);


     return "ticket cancelled successfully";
 }

 public List<String> ticketsBookedByUser(int userId){
    return ticketRepository.ticketsBookedByUser(userId);
 }


 public int totalCollectionsForAMovie(String name){
     return ticketRepository.totalCollectionsForAMovie(name);
 }
}

package com.example.Book_My_Show.Controllers;

import com.example.Book_My_Show.EntryDTOs.TicketEntryDto;
import com.example.Book_My_Show.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;
    @PostMapping("/book")
    public String bookTicket(TicketEntryDto ticketEntryDto) throws Exception {


//            try {
                String result = ticketService.bookTicket(ticketEntryDto);
                return result;
//            }catch(Exception e){
//                return "ticket not booked";
//            }
    }

    @GetMapping("/cancel_ticket")
    public String cancelTicket(@RequestParam("ticketId") Integer ticketId){
        return ticketService.cancelTicket(ticketId);
    }


    @GetMapping("/get_tickets_of_user")
    public List<String> ticketsBookedByUser(@RequestParam("userId") Integer userId){
        return ticketService.ticketsBookedByUser(userId);
    }

    @GetMapping("/get_total_collections_for_a_movie")
    public int totalCollectionsForAMovie(@RequestParam("name") String name){
        return ticketService.totalCollectionsForAMovie(name);
    }
}

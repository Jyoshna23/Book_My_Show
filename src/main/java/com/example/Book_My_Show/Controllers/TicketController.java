package com.example.Book_My_Show.Controllers;

import com.example.Book_My_Show.EntryDTOs.TicketEntryDto;
import com.example.Book_My_Show.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

package com.example.Book_My_Show.Convertors;

import com.example.Book_My_Show.EntryDTOs.TicketEntryDto;
import com.example.Book_My_Show.Models.Tickets;

public class TicketConvertor {
    
    public static Tickets ticketDtoToEntity(TicketEntryDto ticketEntryDto){
        Tickets tickets = new Tickets();

        return tickets;
    }
}

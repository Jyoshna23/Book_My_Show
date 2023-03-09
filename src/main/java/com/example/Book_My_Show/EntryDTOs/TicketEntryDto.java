package com.example.Book_My_Show.EntryDTOs;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TicketEntryDto {

    private int userId;

    private List<String> requestedSeat = new ArrayList<>();

    private int showId;


}

package com.example.Book_My_Show.EntryDTOs;

import lombok.Data;

@Data
public class TheatreEntryDto {
   private String name;

    private String location;

    private int noOfClassicSeatsCount;

    private int noOfPremiumSeatsCount;

}

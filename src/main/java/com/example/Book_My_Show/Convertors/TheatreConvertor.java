package com.example.Book_My_Show.Convertors;

import com.example.Book_My_Show.EntryDTOs.TheatreEntryDto;
import com.example.Book_My_Show.Models.Theatre;

public class TheatreConvertor {

    public static Theatre theatreDtoToEntity(TheatreEntryDto theatreEntryDto){
        Theatre theatre = Theatre.builder().name(theatreEntryDto.getName()).location(theatreEntryDto.getLocation())
                .build();

        return theatre;
    }
}

package com.example.Book_My_Show.Convertors;

import com.example.Book_My_Show.EntryDTOs.ShowEntryDto;
import com.example.Book_My_Show.Models.Show;

public class ShowConvertor {

    public static Show showDtoToEntity(ShowEntryDto showEntryDto){
        Show show = Show.builder().showDate(showEntryDto.getShowDate())
                .showTime(showEntryDto.getShowTime())
                .showType(showEntryDto.getShowType()).build();

        return show;
    }
}

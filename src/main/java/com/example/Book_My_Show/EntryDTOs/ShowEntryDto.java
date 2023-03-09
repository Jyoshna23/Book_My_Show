package com.example.Book_My_Show.EntryDTOs;

import com.example.Book_My_Show.Enums.ShowType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ShowEntryDto {

    private LocalDate showDate;

    private LocalTime showTime;

    private ShowType showType;

    private int movieId;

    private int theatreId;

    private int classicSeatPrice;

    private int premiumSeatPrice;
}

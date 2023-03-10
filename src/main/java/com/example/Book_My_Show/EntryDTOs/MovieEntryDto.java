package com.example.Book_My_Show.EntryDTOs;

import com.example.Book_My_Show.Enums.Genre;
import com.example.Book_My_Show.Enums.Language;
import lombok.Data;

@Data
public class MovieEntryDto {

    private String name;

    private double rating;

    private int duration;

    private Genre genre;

    private Language language;



}

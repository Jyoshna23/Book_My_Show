package com.example.Book_My_Show.EntryDTOs;

import com.example.Book_My_Show.Enums.Genre;
import com.example.Book_My_Show.Enums.Language;
import com.example.Book_My_Show.Models.Movie;
import lombok.Data;

import java.util.List;

@Data
public class MovieResponseDto {

    private String name;

    private double rating;

    private int duration;

    private Genre genre;

    private Language language;


}

package com.example.Book_My_Show.Convertors;

import com.example.Book_My_Show.EntryDTOs.MovieEntryDto;
import com.example.Book_My_Show.Models.Movie;

public class MovieConvertor {


    public static Movie movieDtoToEntity(MovieEntryDto movieEntryDto) {
        Movie movie = Movie.builder().name(movieEntryDto.getName()).rating(movieEntryDto.getRating())
                .duration(movieEntryDto.getDuration()).build();
        return movie;
    }
}

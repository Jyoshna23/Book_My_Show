package com.example.Book_My_Show.Services;

import com.example.Book_My_Show.Convertors.MovieConvertor;
import com.example.Book_My_Show.EntryDTOs.MovieEntryDto;
import com.example.Book_My_Show.Models.Movie;
import com.example.Book_My_Show.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String addMovie(MovieEntryDto movieEntryDto){
        Movie movie = MovieConvertor.movieDtoToEntity(movieEntryDto);

        movieRepository.save(movie);
        return "Movie added successfully";

    }
}

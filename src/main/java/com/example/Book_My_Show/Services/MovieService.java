package com.example.Book_My_Show.Services;

import com.example.Book_My_Show.Convertors.MovieConvertor;
import com.example.Book_My_Show.EntryDTOs.MovieEntryDto;
import com.example.Book_My_Show.EntryDTOs.MovieResponseDto;
import com.example.Book_My_Show.Models.Movie;
import com.example.Book_My_Show.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String addMovie(MovieEntryDto movieEntryDto){
        Movie movie = MovieConvertor.movieDtoToEntity(movieEntryDto);

        movieRepository.save(movie);
        return "Movie added successfully";

    }


    public MovieResponseDto getMovie(Integer id){
        Movie movie = movieRepository.findById(id).get();
        MovieResponseDto movieResponseDto = new MovieResponseDto();

        movieResponseDto.setName(movie.getName());
        movieResponseDto.setDuration(movie.getDuration());
        movieResponseDto.setGenre(movie.getGenre());
        movieResponseDto.setLanguage(movie.getLanguage());
        movieResponseDto.setRating(movie.getRating());

        return movieResponseDto;
    }



        public List<MovieResponseDto> getAllMovies() {
            List<Movie> movies = movieRepository.findAll(); // Get list of Movie entities from somewhere

            List<MovieResponseDto> movieResponseDtos = movies.stream()
                    .map(movie -> {
                        MovieResponseDto movieResponseDto = new MovieResponseDto();
                        movieResponseDto.setName(movie.getName());
                        movieResponseDto.setDuration(movie.getDuration());
                        movieResponseDto.setGenre(movie.getGenre());
                        movieResponseDto.setLanguage(movie.getLanguage());
                        movieResponseDto.setRating(movie.getRating());
                        return movieResponseDto;
                    })
                    .collect(Collectors.toList());

            return movieResponseDtos;
        }

    public List<String> getMovieNameAndMaxShows(){
        return movieRepository.getMovieNameWithMaxShows();
    }
}


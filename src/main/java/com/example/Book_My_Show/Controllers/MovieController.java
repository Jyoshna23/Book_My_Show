package com.example.Book_My_Show.Controllers;

import com.example.Book_My_Show.EntryDTOs.MovieEntryDto;
import com.example.Book_My_Show.EntryDTOs.MovieResponseDto;
import com.example.Book_My_Show.Models.Movie;
import com.example.Book_My_Show.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add_movie")
    public ResponseEntity<String> addMovie(@RequestBody MovieEntryDto movieEntryDto){

        try{
            String result = movieService.addMovie(movieEntryDto);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }catch(Exception e){
            String response = "Movie not added";
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("get_movie")
    public MovieResponseDto getMovie(@RequestParam("id") Integer id){
        return movieService.getMovie(id);
    }


    @GetMapping("/get_all_movies")
    public List<MovieResponseDto> getAllMovies(){
        return movieService.getAllMovies();
    }


    @GetMapping("/get_movie_name_with_max_shows")
    public List<String> getMovieNameWithMaxShows(){
        return movieService.getMovieNameAndMaxShows();
    }
}

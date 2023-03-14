package com.example.Book_My_Show.Controllers;

import com.example.Book_My_Show.EntryDTOs.TheatreEntryDto;
import com.example.Book_My_Show.EntryDTOs.TheatreResponseDto;
import com.example.Book_My_Show.Models.Theatre;
import com.example.Book_My_Show.Services.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theatre")
public class TheatreController {

    @Autowired
    TheatreService theatreService;

    @PostMapping("/add_theatre")
    public ResponseEntity<String> addTheatre(@RequestBody TheatreEntryDto theatreEntryDto){

        try{
            String result = theatreService.addTheatre(theatreEntryDto);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }catch(Exception e){
            String response = "Theatre not created";
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get_theatres_list")
    public List<TheatreResponseDto> getTheatreList(){
        return theatreService.getTheatreList();
    }


    @GetMapping("/count_of_unique_theatre_location")
    public int countOfUniqueLocationOfTheatre(@RequestParam("name") String name){
        return theatreService.countOfUniqueLocationOfTheatre(name);
    }


    @GetMapping("list_of_theatres_at_particular_time")
    public List<String> getListOfTheatreAtParticularTime(String show_time){
        return theatreService.getListOfTheatreAtParticularTime(show_time);
    }


    @GetMapping("get_all_movies_in_a_theatre")
    List<String> getAllMoviesInATheatre(@RequestParam("id") Integer theatreId){
        return theatreService.getAllMoviesInATheatre(theatreId);
    }
}

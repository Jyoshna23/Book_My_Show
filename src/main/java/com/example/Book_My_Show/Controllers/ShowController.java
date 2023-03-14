package com.example.Book_My_Show.Controllers;

import com.example.Book_My_Show.EntryDTOs.ShowEntryDto;
import com.example.Book_My_Show.EntryDTOs.ShowResponseDto;
import com.example.Book_My_Show.Services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/shows")
public class ShowController {

    @Autowired
    ShowService showService;

    @PostMapping("/add_show")
    public ResponseEntity<String> addShow(@RequestBody ShowEntryDto showEntryDto){

        return new ResponseEntity<>(showService.addShow(showEntryDto), HttpStatus.CREATED);
    }


    @GetMapping("/get_showtime")
    public List<LocalTime> getShowTimeForTheatreAndMovie(@RequestParam("theatreId") Integer theatreId, @RequestParam("movieId") Integer movieId ){
        return showService.getShowTimeForTheatreAndMovie(theatreId,movieId);
    }
}

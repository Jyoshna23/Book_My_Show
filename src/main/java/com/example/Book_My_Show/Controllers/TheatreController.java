package com.example.Book_My_Show.Controllers;

import com.example.Book_My_Show.EntryDTOs.TheatreEntryDto;
import com.example.Book_My_Show.Models.Theatre;
import com.example.Book_My_Show.Services.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}

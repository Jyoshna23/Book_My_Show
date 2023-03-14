package com.example.Book_My_Show.Services;

import com.example.Book_My_Show.Convertors.TheatreConvertor;
import com.example.Book_My_Show.EntryDTOs.MovieResponseDto;
import com.example.Book_My_Show.EntryDTOs.TheatreEntryDto;
import com.example.Book_My_Show.EntryDTOs.TheatreResponseDto;
import com.example.Book_My_Show.Enums.SeatType;
import com.example.Book_My_Show.Models.Movie;
import com.example.Book_My_Show.Models.Theatre;
import com.example.Book_My_Show.Models.TheatreSeats;
import com.example.Book_My_Show.Repositories.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TheatreService {

    @Autowired
    TheatreRepository theatreRepository;

    public String addTheatre(TheatreEntryDto theatreEntryDto) throws Exception{

        if(theatreEntryDto.getName()==null||theatreEntryDto.getLocation()==null){
            throw new Exception("Name and location should valid");
        }

        Theatre theatre = TheatreConvertor.theatreDtoToEntity(theatreEntryDto);



        List<TheatreSeats> theatreSeatsList = theatreSeats(theatreEntryDto,theatre);

        theatre.setTheatreSeatsList(theatreSeatsList);

        theatreRepository.save(theatre);

        return "Theatre added successfully";
    }

    private List<TheatreSeats> theatreSeats(TheatreEntryDto theatreEntryDto,Theatre theatre){

        int classicSeats = theatreEntryDto.getNoOfClassicSeatsCount();
        int premiumSeats = theatreEntryDto.getNoOfPremiumSeatsCount();

        List<TheatreSeats> theatreSeatsList = new ArrayList<>();

        for(int count = 1; count <= classicSeats; count++){
            //We need to make a new TheatreSeat for each iteration

            TheatreSeats theatreSeats = TheatreSeats.builder().seatType(SeatType.CLASSIC).seatNo(count +"C")
                    .theatre(theatre).build();

            theatreSeatsList.add(theatreSeats);
        }

        for(int count = 1; count <= premiumSeats; count++){
            TheatreSeats theatreSeats = TheatreSeats.builder().seatType(SeatType.PREMIUM).seatNo(count +"P")
                    .theatre(theatre).build();
            theatreSeatsList.add(theatreSeats);
        }

        return theatreSeatsList;
    }

//Get theatreList
    public List<TheatreResponseDto> getTheatreList(){
        List<Theatre> theatres = theatreRepository.findAll(); // Get list of Movie entities from somewhere

        List<TheatreResponseDto> theatreResponseDtos = theatres.stream()
                .map(theatre -> {
                   TheatreResponseDto theatreResponseDto = new TheatreResponseDto();
                   theatreResponseDto.setName(theatre.getName());
                   theatreResponseDto.setLocation(theatre.getLocation());
                   return theatreResponseDto;
                })
                .collect(Collectors.toList());
        return theatreResponseDtos;
    }

    public int countOfUniqueLocationOfTheatre(String name){
        return theatreRepository.countOfUniqueLocationOfTheatre(name);
    }

    public List<String> getAllMoviesInATheatre(int theatreId){
        return theatreRepository.getAllMoviesInATheatre(theatreId);
    }


    public List<String> getListOfTheatreAtParticularTime(String show_time){
        return theatreRepository.getListOfTheatreAtParticularTime(show_time);
    }
}

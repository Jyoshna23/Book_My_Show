package com.example.Book_My_Show.Services;

import com.example.Book_My_Show.BookMyShowApplication;
import com.example.Book_My_Show.Convertors.ShowConvertor;
import com.example.Book_My_Show.EntryDTOs.ShowEntryDto;
import com.example.Book_My_Show.EntryDTOs.ShowResponseDto;
import com.example.Book_My_Show.Enums.SeatType;
import com.example.Book_My_Show.Models.*;
import com.example.Book_My_Show.Repositories.MovieRepository;
import com.example.Book_My_Show.Repositories.ShowRepository;
import com.example.Book_My_Show.Repositories.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.sql.Time.*;

@Service
public class ShowService {

    @Autowired
    ShowRepository showRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheatreRepository theatreRepository;




    public String addShow(ShowEntryDto showEntryDto){

        Show show = ShowConvertor.showDtoToEntity(showEntryDto);

        int movieId = showEntryDto.getMovieId();
        int theatreId = showEntryDto.getTheatreId();

        Movie movie = movieRepository.findById(movieId).get();
        Theatre theatre = theatreRepository.findById(theatreId).get();


        show.setMovie(movie);
        show.setTheatre(theatre);

        List<ShowSeats> showSeatsList = createShowSeats(showEntryDto, show) ;
        show.setShowSeatsList(showSeatsList);

        //Now we need to set the parent entities(MOvie,theatre) which are foreign keys for show

        show = showRepository.save(show); // This we are writing to avoid the duplicacy of show as it is a child for movie and theatre

        movie.getShowList().add(show);
        theatre.getShowList().add(show);

        movieRepository.save(movie);

        theatreRepository.save(theatre);

        return "Show added Successfully";
    }

    private List<ShowSeats> createShowSeats(ShowEntryDto showEntryDto,Show show){

        //First I need to have theatre to have a show. So i will bring the theatre

        Theatre theatre = show.getTheatre();

        //I fetched the theatre seats list.
        List<TheatreSeats> theatreSeatsList = theatre.getTheatreSeatsList();

        List<ShowSeats> showSeatsList = new ArrayList<>();
        //Now I will Traverse the list and for each seat I will create a show seat entity

        for(TheatreSeats theatreSeats : theatreSeatsList){

            ShowSeats showSeats = new ShowSeats();

            //Here I have set the seatNo and type from theatre entity
            showSeats.setSeatNo(theatreSeats.getSeatNo());
            showSeats.setSeatType(theatreSeats.getSeatType());


            //I have set the price for the seats.
            if(theatreSeats.getSeatType().equals(SeatType.CLASSIC)){
                showSeats.setPrice(showEntryDto.getClassicSeatPrice());
            }
            else {
                showSeats.setPrice(showEntryDto.getPremiumSeatPrice());
            }

            showSeats.setBooked(false);
            showSeats.setShow(show); // show is the parent of showSeat entity, so setting foreign key.

            showSeatsList.add(showSeats);
        }
        return showSeatsList;
    }


    public List<LocalTime> getShowTimeForTheatreAndMovie(int theatreId, int movieId ){

        List<Time> time = showRepository.getShowTimeForTheatreAndMovie(theatreId, movieId);
        List<LocalTime> localTimes = convertToLocalTime(time);
        return localTimes;
    }


    public List<LocalTime> convertToLocalTime(List<Time> times) {
        return times.stream()
                .map(time -> time.toLocalTime())
                .collect(Collectors.toList());
    }
}

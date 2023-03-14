package com.example.Book_My_Show.Repositories;

import com.example.Book_My_Show.EntryDTOs.ShowResponseDto;
import com.example.Book_My_Show.Models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface ShowRepository extends JpaRepository<Show,Integer> {

    @Query(value="select show_time from shows where movie_id=:movieId AND theatre_id=:theatreId",nativeQuery = true)
    List<Time> getShowTimeForTheatreAndMovie(int theatreId, int movieId );

}

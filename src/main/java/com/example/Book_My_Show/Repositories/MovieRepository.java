package com.example.Book_My_Show.Repositories;

import com.example.Book_My_Show.EntryDTOs.MovieResponseDto;
import com.example.Book_My_Show.Models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {

    List<Movie> findAll();

    @Query(value = "select name,(select count(*) from shows s where s.movie_id = m.id) AS show_count from movie m ORDER BY show_count DESC LIMIT 1",nativeQuery = true)
    List<String> getMovieNameWithMaxShows();
}

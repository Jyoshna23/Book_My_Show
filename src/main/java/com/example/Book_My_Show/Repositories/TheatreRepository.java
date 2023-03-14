package com.example.Book_My_Show.Repositories;

import com.example.Book_My_Show.Models.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre,Integer>{

    List<Theatre> findAll();

    @Query(value = " select count(distinct location) from theatre where name=:name",nativeQuery = true)
    int countOfUniqueLocationOfTheatre(String name);


    @Query(value = " select name,show_time from theatre Join shows ON theatre.id=shows.id having show_time=:show_time",nativeQuery = true)
    List<String> getListOfTheatreAtParticularTime(String show_time);


    @Query(value = "select distinct m.name from movie m join shows s ON m.id = s.movie_id join theatre t ON s.theatre_id = t.id where t.id =:theatreId",nativeQuery = true)
    List<String> getAllMoviesInATheatre(int theatreId);
}

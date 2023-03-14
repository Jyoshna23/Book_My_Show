package com.example.Book_My_Show.Repositories;

import com.example.Book_My_Show.Models.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Tickets,Integer> {

    @Query(value = " select booked_seats from tickets where user_id=:userId",nativeQuery = true)
    List<String> ticketsBookedByUser(int userId);

    @Query(value = "select SUM(total_amount) from tickets where movie_name=:name",nativeQuery = true)
    int totalCollectionsForAMovie(String name);

}

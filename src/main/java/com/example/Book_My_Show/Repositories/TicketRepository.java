package com.example.Book_My_Show.Repositories;

import com.example.Book_My_Show.Models.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Tickets,Integer> {
}

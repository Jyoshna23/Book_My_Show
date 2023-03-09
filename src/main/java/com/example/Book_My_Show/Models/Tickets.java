package com.example.Book_My_Show.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name="tickets")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Tickets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int totalAmount; //totalAmount

    private String movieName;

    private LocalTime showTime;

    private String theatreName;


    private LocalDate showDate;

    private String ticketId = UUID.randomUUID().toString();

    private String bookedSeats;


    //Tickets entity is a child entity for user.
    // Mapping will be Many to one

    @ManyToOne
    @JoinColumn
    private User user;

    @ManyToOne
    @JoinColumn
    private Show show;


}

package com.example.Book_My_Show.Models;

import com.example.Book_My_Show.Enums.ShowType;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="shows")
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate showDate;

    private LocalTime showTime;

    @Enumerated(value = EnumType.STRING)
    private ShowType showType;

    //show is the child for movie entity
    // One movie can have many shows, so it is Many to one relationship.

    @ManyToOne
    @JoinColumn
    private Movie movie;

    //show is also a child entity for theatre.
    //It has many to one relationship
    @ManyToOne
    @JoinColumn
    private Theatre theatre;

    //Show is the parent entity for showSeats
    //It has one to many relationship
    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    List<ShowSeats> showSeatsList = new ArrayList<>();

    //show is also a parent entity for tickets.
    //one to many relationship
    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    List<Tickets> ticketsList = new ArrayList<>();

}

package com.example.Book_My_Show.Models;

import com.example.Book_My_Show.Enums.SeatType;
import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name="show_seats")
public class ShowSeats {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private boolean isBooked;

    private int price;

    private int seatNo;

    private LocalTime bookedTime;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;


    //showseats is a child entity for show.
    //one show can have many showseats, so many to one relationship
    @ManyToOne
    @JoinColumn
    private Show show;
}

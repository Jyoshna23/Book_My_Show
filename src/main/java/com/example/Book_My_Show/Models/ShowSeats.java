package com.example.Book_My_Show.Models;

import com.example.Book_My_Show.Enums.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name="show_seats")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ShowSeats {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private boolean isBooked;

    private int price;

    private String seatNo;

    private Date bookedTime;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;


    //showseats is a child entity for show.
    //one show can have many showseats, so many to one relationship
    @ManyToOne
    @JoinColumn
    private Show show;


}

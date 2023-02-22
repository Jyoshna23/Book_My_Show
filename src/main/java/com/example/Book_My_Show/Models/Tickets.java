package com.example.Book_My_Show.Models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name="tickets")
public class Tickets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int price;

    private String movieName;

    private LocalTime showTime;

    private String theatreName;

    @CreationTimestamp
    private Date showDate;


    //Tickets entity is a child entity for user.
    // Mapping will be Many to one

    @ManyToOne
    @JoinColumn
    private User user;

    @ManyToOne
    @JoinColumn
    private Show show;
}

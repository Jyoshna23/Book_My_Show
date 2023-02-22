package com.example.Book_My_Show.Models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(unique = true)
    private String email;

    private int age;

    private String mobNo;

    private String address;


    // User has a relationship with ticket.
    //One user can book any number of tickets. so we have one to many relationship.
    //User will be parent entity and ticket is child entity

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    List<Tickets> ticketsList = new ArrayList<>();



}




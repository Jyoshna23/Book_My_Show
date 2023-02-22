package com.example.Book_My_Show.Models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="theatre")
public class Theatre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String location;

    //theatre to show relationship. One theatre can have many shows.
    //1 --> many
    @OneToMany(mappedBy = "theatre",cascade = CascadeType.ALL)
    List<Show> showList = new ArrayList<>();

    @OneToMany(mappedBy = "theatre",cascade = CascadeType.ALL)
    List<TheatreSeats> theatreSeatsList = new ArrayList<>();
}

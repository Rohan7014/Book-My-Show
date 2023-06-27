package com.example.BookMyShow.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "tickets")
@Data
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int totalPrice;
    private boolean seat;
    private LocalTime localTime;
    private Date date;
    private String movieName;
    private String theaterName;
}

package com.example.BookMyShow.Models;

import com.example.BookMyShow.Enums.Genre;
import com.example.BookMyShow.Enums.Language;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "movies")
@Data
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String movieName;
    private double duration;
    @Column(scale = 2)
    private double rating;
    private Date releaseDate;
    @Enumerated(value = EnumType.STRING)
    private Genre genre;
    @Enumerated(value = EnumType.STRING)
    private Language language;

}

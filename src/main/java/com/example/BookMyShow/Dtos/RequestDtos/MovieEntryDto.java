package com.example.BookMyShow.Dtos.RequestDtos;

import com.example.BookMyShow.Enums.Genre;
import com.example.BookMyShow.Enums.Language;
import lombok.Data;

import java.util.Date;

@Data
public class MovieEntryDto {
    private String movieName;
    private double duration;
    private double rating;
    private Date releaseDate;
    private Genre genre;
    private Language language;
}

package com.example.BookMyShow.Transformers;

import com.example.BookMyShow.Dtos.RequestDtos.MovieEntryDto;
import com.example.BookMyShow.Models.Movie;

public class MovieTransformers {
    public static Movie convertDtoToEntity(MovieEntryDto movieEntryDto){
        Movie movie= Movie.builder().movieName(movieEntryDto.getMovieName())
                .duration(movieEntryDto.getDuration())
                .genre(movieEntryDto.getGenre())
                .language(movieEntryDto.getLanguage())
                .rating(movieEntryDto.getRating())
                .releaseDate(movieEntryDto.getReleaseDate())
                .build();
        return movie;
    }
}

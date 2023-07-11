package com.example.BookMyShow.Service;

import com.example.BookMyShow.Dtos.RequestDtos.MovieEntryDto;
import com.example.BookMyShow.Models.Movie;
import com.example.BookMyShow.Repository.MovieRepository;
import com.example.BookMyShow.Transformers.MovieTransformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    public String addMovie(MovieEntryDto movieEntryDto){
        Movie movie= MovieTransformers.convertDtoToEntity(movieEntryDto);
        movieRepository.save(movie);
        return "Movie Added Successfully";
    }
}

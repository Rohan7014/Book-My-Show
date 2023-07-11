package com.example.BookMyShow.Controller;

import com.example.BookMyShow.Dtos.RequestDtos.MovieEntryDto;
import com.example.BookMyShow.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @PostMapping("/add")
    public String addMovie(@RequestBody MovieEntryDto movieEntryDto){
        return movieService.addMovie(movieEntryDto);
    }
}

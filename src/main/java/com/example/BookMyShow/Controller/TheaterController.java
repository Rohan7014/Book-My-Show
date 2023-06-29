package com.example.BookMyShow.Controller;

import com.example.BookMyShow.Dtos.RequestDtos.TheaterEntryDto;
import com.example.BookMyShow.Dtos.RequestDtos.TheaterSeatsEntryDto;
import com.example.BookMyShow.Service.TheaterSeatService;
import com.example.BookMyShow.Service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theater")
public class TheaterController {
    @Autowired
    private TheaterService theaterService;
    @Autowired
    private TheaterSeatService theaterSeatService;
    @PostMapping("/add")
    public String addTheater(@RequestBody TheaterEntryDto theaterEntryDto){
        return theaterService.addTheater(theaterEntryDto);
    }
    @PostMapping("/addTheaterSeats")
    public String addTheaterSeats(@RequestBody TheaterSeatsEntryDto theaterSeatsEntryDto){
        return theaterSeatService.addTheaterSeats(theaterSeatsEntryDto);
    }
}

package com.example.BookMyShow.Service;

import com.example.BookMyShow.Dtos.RequestDtos.TheaterEntryDto;
import com.example.BookMyShow.Models.Theater;
import com.example.BookMyShow.Repository.TheaterRepository;
import com.example.BookMyShow.Transformers.TheaterTransformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TheaterService {
    @Autowired
    private TheaterRepository theaterRepository;
    public String addTheater(TheaterEntryDto theaterEntryDto){
        // Entity that Saves into the DB
        // Convert the EntryDto --> Entity and then save it
        Theater theater= TheaterTransformers.convertDtoToEntity(theaterEntryDto);
        theaterRepository.save(theater);
        return "Theater Added Successfully";
    }
}

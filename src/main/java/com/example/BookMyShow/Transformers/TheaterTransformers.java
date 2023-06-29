package com.example.BookMyShow.Transformers;

import com.example.BookMyShow.Dtos.RequestDtos.TheaterEntryDto;
import com.example.BookMyShow.Models.Theater;

public class TheaterTransformers {
    public static Theater convertDtoToEntity(TheaterEntryDto theaterEntryDto){
        Theater theater=Theater.builder().location(theaterEntryDto.getLocation())
                .name(theaterEntryDto.getName()).build();
        return theater;
    }
}

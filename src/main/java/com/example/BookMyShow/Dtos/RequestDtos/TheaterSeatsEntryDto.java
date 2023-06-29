package com.example.BookMyShow.Dtos.RequestDtos;

import lombok.Data;

@Data
public class TheaterSeatsEntryDto {
    private int noOfSeatsIn1Row;
    private int noOfClassicSeats;
    private int noOfPremiumSeats;
    private String location;
}

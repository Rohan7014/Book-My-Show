package com.example.BookMyShow.Dtos.RequestDtos;

import lombok.Data;

@Data
public class ShowSeatsDto {
    private int showId;
    private int priceForClassicSeats;
    private int priceForPremiumSeats;

}

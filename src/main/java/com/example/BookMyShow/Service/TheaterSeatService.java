package com.example.BookMyShow.Service;

import com.example.BookMyShow.Dtos.RequestDtos.TheaterSeatsEntryDto;
import com.example.BookMyShow.Enums.SeatType;
import com.example.BookMyShow.Models.Theater;
import com.example.BookMyShow.Models.TheaterSeat;
import com.example.BookMyShow.Repository.TheaterRepository;
import com.example.BookMyShow.Repository.TheaterSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheaterSeatService {
    @Autowired
    private TheaterSeatRepository theaterSeatRepository;
    @Autowired
    private TheaterRepository theaterRepository;
    public String addTheaterSeats(TheaterSeatsEntryDto theaterSeatsEntryDto){
        // We Need to save the TheaterSeat Entity
        int column=theaterSeatsEntryDto.getNoOfSeatsIn1Row();
        int noOfClassicSeats=theaterSeatsEntryDto.getNoOfClassicSeats();
        int noOfPremiumSeats=theaterSeatsEntryDto.getNoOfPremiumSeats();

        String location=theaterSeatsEntryDto.getLocation();
        Theater theater =theaterRepository.findByLocation(location);

        List<TheaterSeat> theaterSeatList=theater.getTheaterSeatList();
        int counter=1;
        char ch='A';
        //This is done for the CLASSIC Seats
        for(int count=1;count<=noOfClassicSeats;count++){
            String seatNo=counter+"";
            seatNo=seatNo+ch;
            ch++;
            if((ch-'A')==column){
                ch='A';
                counter++;
            }
            //Storing parent info into child
            TheaterSeat theaterSeat=new TheaterSeat();
            theaterSeat.setSeatNo(seatNo);
            theaterSeat.setTheater(theater);
            theaterSeat.setSeatType(SeatType.CLASSIC);
            // bidirectional mapping Storing the child entity in the parent entity
            theaterSeatList.add(theaterSeat);
        }
        // Let Do For PREMIUM Seats
        for(int count=1;count<=noOfPremiumSeats;count++){
            String seatNo=counter+"";
            seatNo=seatNo+ch;
            ch++;
            if((ch-'A')==column){
                ch='A';
                counter++;
            }
            TheaterSeat theaterSeat=new TheaterSeat();
            theaterSeat.setTheater(theater);
            theaterSeat.setSeatType(SeatType.PREMIUM);
            theaterSeat.setSeatNo(seatNo);

            // bidirectional mapping Storing the child entity in the parent entity
            theaterSeatList.add(theaterSeat);
        }
        theaterRepository.save(theater);
        return "Theater Seats Have Been Successfully Added";
    }
}

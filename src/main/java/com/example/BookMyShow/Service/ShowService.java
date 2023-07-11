package com.example.BookMyShow.Service;

import com.example.BookMyShow.Dtos.RequestDtos.AddShowDto;
import com.example.BookMyShow.Dtos.RequestDtos.ShowSeatsDto;
import com.example.BookMyShow.Enums.SeatType;
import com.example.BookMyShow.Exception.MovieNotFound;
import com.example.BookMyShow.Exception.ShowNotFound;
import com.example.BookMyShow.Exception.TheaterNotFound;
import com.example.BookMyShow.Models.*;
import com.example.BookMyShow.Repository.MovieRepository;
import com.example.BookMyShow.Repository.ShowRepository;
import com.example.BookMyShow.Repository.TheaterRepository;
import com.example.BookMyShow.Transformers.ShowTransformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.support.ReflectivePropertyAccessor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShowService {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private TheaterRepository theaterRepository;
    public String addShow(AddShowDto showDto)throws TheaterNotFound, MovieNotFound{
        Show show= ShowTransformers.convertDtoToEntity(showDto);

        // Set Movie and theater Entity
        Optional<Movie> movieOptional=movieRepository.findById(showDto.getMovieId());
        if(!movieOptional.isPresent()){
            throw new MovieNotFound("Movie is not found");
        }
        Optional<Theater> theaterOptional=theaterRepository.findById(showDto.getTheaterId());
        if(!theaterOptional.isPresent()){
            throw new TheaterNotFound("Movie is not found");
        }
        Movie movie=movieOptional.get();
        Theater theater=theaterOptional.get();

        //setting the foreign key attribute
        show.setMovie(movie);
        show.setTheater(theater);

        // set the show to get show id
        show=showRepository.save(show);

        movie.getShowList().add(show);
        movieRepository.save(movie);
        theater.getShowList().add(show);
        theaterRepository.save(theater);

        return "Show has been Added and Show id is "+show.getId();
    }
    public String associateShowSeats(ShowSeatsDto showSeatsDto)throws ShowNotFound {
        Optional<Show> optionalShow=showRepository.findById(showSeatsDto.getShowId());
        // Validation check
        if(!optionalShow.isPresent()){
            throw new ShowNotFound("Show Id Incorrect!!");
        }
        // valid show now
        Show show=optionalShow.get();
        //We need to theater seats
        Theater theater=show.getTheater();
        List<TheaterSeat> theaterSeatList=theater.getTheaterSeatList();

        // Each seat needs to be added in showseatlist
        List<ShowSeat> showSeatList=show.getShowSeatList();

        for(TheaterSeat theaterSeat:theaterSeatList){
            ShowSeat showSeat=new ShowSeat();

            showSeat.setSeatNo(theaterSeat.getSeatNo());
            showSeat.setSeatType(theaterSeat.getSeatType());

            if(showSeat.getSeatType().equals(SeatType.CLASSIC))
                showSeat.setPrice(showSeatsDto.getPriceForClassicSeats());
            else
                showSeat.setPrice(showSeatsDto.getPriceForPremiumSeats());

            // Foreign key mapping
            showSeat.setShow(show);
            showSeat.setAvailable(true);
            showSeat.setFoodAttached(false);

            showSeatList.add(showSeat);
        }
        showRepository.save(show);
        // child will automatically get saves

        return "Show seats has been Successfully added1!";
    }
}

package com.example.BookMyShow.Controller;

import com.example.BookMyShow.Dtos.RequestDtos.AddShowDto;
import com.example.BookMyShow.Dtos.RequestDtos.ShowSeatsDto;
import com.example.BookMyShow.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/show")
public class ShowController {
    @Autowired
    private ShowService showService;
    @PostMapping("/add")
    public String addShow(@RequestBody AddShowDto addShowDto){
        try {
            return showService.addShow(addShowDto);
        }catch (Exception e) {
            return e.getMessage();
        }
    }
    @PostMapping("/Associate seats")
    public String associateSeats(@RequestBody ShowSeatsDto showSeatsDto){
        try{
            return showService.associateShowSeats(showSeatsDto);
        }catch (Exception e){
            return e.getMessage();
        }
    }
}

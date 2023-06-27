package com.example.BookMyShow.Controller;

import com.example.BookMyShow.Dtos.RequestDtos.AddUserDto;
import com.example.BookMyShow.Dtos.ResponseDtos.UserResponseDto;
import com.example.BookMyShow.Models.User;
import com.example.BookMyShow.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/add")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/add")
    public String addUser(@RequestBody AddUserDto user){
        try{
            String result=userService.addUser(user);
            return result;
        }catch (Exception e){
            return e.getMessage();
        }
    }
    // Get Oldest User Object By Age
    @GetMapping("/getOlderUser")
    public UserResponseDto getOldestUser(){
        try{
            UserResponseDto userResponseDto=userService.getOldestUser();
            userResponseDto.setStatusCode("200");
            userResponseDto.setStatusMessage("Success");
            return userResponseDto;
        }catch (Exception e){
            UserResponseDto responseDto=new UserResponseDto();
            responseDto.setStatusCode("500");
            responseDto.setStatusMessage("Failure");
            return responseDto;
        }
    }
    @GetMapping("/findUsersGreaterThanAge")
    public List<User> getAllUser(@RequestParam("age") Integer age){
        return userService.getAllUserGreaterThan(age);
    }
}

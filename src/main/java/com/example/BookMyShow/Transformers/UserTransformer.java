package com.example.BookMyShow.Transformers;

import com.example.BookMyShow.Dtos.RequestDtos.AddUserDto;
import com.example.BookMyShow.Dtos.ResponseDtos.UserResponseDto;
import com.example.BookMyShow.Models.User;

public class UserTransformer {
    public static User convertDtoToEntity(AddUserDto userDto){
//        User user=new User();
//        user.setName(user.getName());
//        user.setMobileNo(user.getMobileNo());
//        user.setAge(user.getAge());
//        user.setEmail(user.getEmail());

        User userObj= User.builder()
                .age(userDto.getAge())
                .email(userDto.getEmailId())
                .mobileNo(userDto.getMobNo())
                .name(userDto.getName())
                .build();
        return userObj;
    }
    public static UserResponseDto convertEntityToDto(User user){
        UserResponseDto userResponseDto=UserResponseDto.builder()
                .age(user.getAge())
                .name(user.getName())
                .mobNo(user.getMobileNo())
                .build();
        return userResponseDto;
    }
}

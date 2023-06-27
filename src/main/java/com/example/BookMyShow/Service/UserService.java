package com.example.BookMyShow.Service;

import com.example.BookMyShow.Dtos.RequestDtos.AddUserDto;
import com.example.BookMyShow.Dtos.ResponseDtos.UserResponseDto;
import com.example.BookMyShow.Exception.NoUserFoundException;
import com.example.BookMyShow.Models.User;
import com.example.BookMyShow.Repository.UserRepository;
import com.example.BookMyShow.Transformers.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public String addUser(AddUserDto userDto){
        User user= UserTransformer.convertDtoToEntity(userDto);
        userRepository.save(user);
        return "User Has Been Added Successful";
    }
    public UserResponseDto getOldestUser() throws NoUserFoundException {
        // Prevent you From Exposing the Primary Key
        // Prevent Infinite Recursion in case it occur
        List<User> userList=userRepository.findAll();
        Integer maxAge=0;
        User userAns=null;
        for(User user:userList){
            if(user.getAge()>maxAge){
                maxAge=user.getAge();
                userAns=user;
            }
        }
        if(userAns==null)
            throw new NoUserFoundException("No User Found");
        // We need To Transform the entity to the UserResponse
        UserResponseDto userResponseDto=UserTransformer.convertEntityToDto(userAns);
        return userResponseDto;
    }

    public List<User> getAllUserGreaterThan(Integer age) {
        List<User> users=userRepository.findUserWithAgeGreater(age);
        return users;
    }
}

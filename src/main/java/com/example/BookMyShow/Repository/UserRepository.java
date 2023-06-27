package com.example.BookMyShow.Repository;

import com.example.BookMyShow.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    @Query(value = "Select * from users where age >=: value ",nativeQuery = true)
    List<User> findUserWithAgeGreater(@Param("value") Integer value);
    //This is a custom Function that you have defined
    // You need to write a query on top of this

}

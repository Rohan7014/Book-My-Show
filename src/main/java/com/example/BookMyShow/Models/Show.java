package com.example.BookMyShow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "shows")
@Data
public class Show {
    private LocalTime localTime;
    private Date date;
}

package com.example.BookMyShow.Models;

import com.example.BookMyShow.Enums.SeatType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "showseats")
@Data
public class ShowSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int seatNo;
    private int price;
    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;
    private boolean isAvailable;
    private boolean isFoodAvailable;
}

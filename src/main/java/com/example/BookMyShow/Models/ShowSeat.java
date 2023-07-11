package com.example.BookMyShow.Models;

import com.example.BookMyShow.Enums.SeatType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "show seats")
@Data
public class ShowSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String  seatNo;
    private int price;
    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;
    private boolean isAvailable;
    private boolean isFoodAttached;
    @ManyToOne
    @JoinColumn
    private Show show;
}

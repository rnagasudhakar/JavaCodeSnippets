package org.example.LLDDesigns.BookMyShow.Controllers;

import org.example.LLDDesigns.BookMyShow.Models.Seat;

import java.time.LocalDateTime;

public interface PricingStrategy {

    double calculatePrice(Seat seat, LocalDateTime startingTime);

}

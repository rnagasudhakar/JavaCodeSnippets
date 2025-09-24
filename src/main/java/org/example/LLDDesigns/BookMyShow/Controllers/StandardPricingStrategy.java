package org.example.LLDDesigns.BookMyShow.Controllers;

import org.example.LLDDesigns.BookMyShow.Models.Seat;
import org.example.LLDDesigns.BookMyShow.Models.SeatType;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class StandardPricingStrategy implements PricingStrategy {
    @Override
    public  double calculatePrice(Seat seat, LocalDateTime showTime) {
        double price = switch (seat.getSeatType()) {
            case SeatType.RECLINER -> 400;
            case SeatType.PREMIUM -> 280;
            case SeatType.ECONOMY -> 150;
        };

        if (showTime.getDayOfWeek() == DayOfWeek.SATURDAY ||
                showTime.getDayOfWeek() == DayOfWeek.SUNDAY) {
            price *=  1.2;
        }


        if (showTime.getHour() < 12) {
            price *= 0.8;
        }

        return price;

    }
}

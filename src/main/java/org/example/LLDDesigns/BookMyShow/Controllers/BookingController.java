package org.example.LLDDesigns.BookMyShow.Controllers;

import org.example.LLDDesigns.BookMyShow.Models.SeatBookingStatus;
import org.example.LLDDesigns.BookMyShow.Models.Show;
import org.example.LLDDesigns.BookMyShow.Models.ShowSeat;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class BookingController {


    private boolean isValidTickets(List<ShowSeat> screenSeats,  List<ShowSeat> seatsToBook){

        if(seatsToBook== null || seatsToBook.isEmpty()){
            return false;
        }

       Map<Integer,SeatBookingStatus> seatBookingStatusMap =  screenSeats.stream().collect(Collectors.toConcurrentMap(ShowSeat::getSeatId,ShowSeat::getSeatBookingStatus));
        return seatsToBook.stream().allMatch(showSeat-> SeatBookingStatus.AVAILABLE.equals(seatBookingStatusMap.get(showSeat.getSeatId())));

    }

    public void bookTickets(Show show, List<ShowSeat> showSeatList) {
        Map<Integer, Lock> locks = new ConcurrentHashMap<>();
        locks.putIfAbsent(show.getShowId(), new ReentrantLock());
        try{
            locks.get(show.getShowId()).lock();
            List<ShowSeat> screenSeats = show.getShowSeatList();
            if(!isValidTickets(screenSeats,showSeatList)){
                throw new RuntimeException("It is not valid");
            }



        }
        finally {
            locks.get(show.getShowId()).unlock();
        }




    }
}

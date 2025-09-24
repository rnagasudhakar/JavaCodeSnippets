package org.example.LLDDesigns.BookMyShow.Models;

public class ShowSeat extends  Seat{

    private SeatBookingStatus seatBookingStatus;
    private double showPrice;

    public ShowSeat(int seatId, int row, Character col, SeatType seatType, double showPrice) {
        super(seatId, row, col, seatType);
        this.seatBookingStatus = SeatBookingStatus.AVAILABLE;
        this.showPrice = showPrice;
    }

    public SeatBookingStatus getSeatBookingStatus() {
        return seatBookingStatus;
    }

    public void setSeatBookingStatus(SeatBookingStatus seatBookingStatus) {
        this.seatBookingStatus = seatBookingStatus;
    }

    public double getShowPrice() {
        return showPrice;
    }

    public void setShowPrice(double showPrice) {
        this.showPrice = showPrice;
    }

}

package org.example.LLDDesigns.BookMyShow.Services;

import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator {
    private static final AtomicInteger seatIdCounter = new AtomicInteger(1);

    public static int getNextSeatId(){
        return seatIdCounter.incrementAndGet();
    }
}

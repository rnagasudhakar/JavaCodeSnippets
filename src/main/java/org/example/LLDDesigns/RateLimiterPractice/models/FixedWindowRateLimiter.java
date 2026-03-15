package org.example.LLDDesigns.RateLimiterPractice.models;

import org.example.LLDDesigns.RateLimiter.enums.RateLimitType;

import java.time.Instant;
import java.util.concurrent.ConcurrentHashMap;

public class FixedWindowRateLimiter extends RateLimiter{

    ConcurrentHashMap<String,Integer> userIdRequest ;
    ConcurrentHashMap<String,Long> currentWindow;
    private final Long windowSize = 5 * 60 * 1000L;

    public FixedWindowRateLimiter(RateLimitType rateLimitType) {
        super(rateLimitType);
        userIdRequest = new ConcurrentHashMap<>();
        currentWindow = new ConcurrentHashMap<>();
    }

    @Override
    public boolean isRequestAllowed(User user) {
        synchronized (user.getUserId()){
            String userId = user.getUserId();
            Long now = System.currentTimeMillis();
            currentWindow.putIfAbsent(userId,now);

            if(currentWindow.get(userId) - now > windowSize){
                currentWindow.put(userId,now);
                userIdRequest.put(userId,1);
            }
            else{
                if(userIdRequest.get(userId).equals(user.getMaxNumberOfRequests())){
                    throw new RuntimeException("429 max requests");
                }
                userIdRequest.put(userId,userIdRequest.get(userId)+1);
            }
            System.out.println("Requests has been allowed");
            return true;
        }
    }
}

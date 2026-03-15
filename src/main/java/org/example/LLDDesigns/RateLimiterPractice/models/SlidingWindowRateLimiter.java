package org.example.LLDDesigns.RateLimiterPractice.models;

import org.example.LLDDesigns.RateLimiter.enums.RateLimitType;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class SlidingWindowRateLimiter extends  RateLimiter {

    ConcurrentHashMap<String, List<Long>> currentWindow;
    private final Long windowSize = 5 * 60 * 1000L;


    public SlidingWindowRateLimiter(RateLimitType rateLimitType) {
        super(rateLimitType);
        currentWindow = new ConcurrentHashMap<>();
    }

    @Override
    public boolean isRequestAllowed(User user) {
        synchronized (user.getUserId()) {
            String userId = user.getUserId();
            Long now = System.currentTimeMillis();
            currentWindow.putIfAbsent(userId, new ArrayList<>());
            List<Long> currentWindowList = currentWindow.get(userId);
            while (!currentWindowList.isEmpty()) {
                if (now - currentWindowList.getFirst() > windowSize) {
                    currentWindowList.remove(currentWindowList.getFirst());
                    continue;
                }
                break;
            }

            if (currentWindowList.size() > user.getMaxNumberOfRequests()) {
                throw new RuntimeException("Too many Requests");
            }
            currentWindowList.add(now);
            currentWindow.put(userId, currentWindowList);
            System.out.println("Requests has been allowed");
            return true;
        }
    }
}

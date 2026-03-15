package org.example.LLDDesigns.RateLimiterPractice.models;

import org.example.LLDDesigns.RateLimiter.enums.RateLimitType;

import java.util.concurrent.ConcurrentHashMap;

public class TokenBucketRateLimiter extends RateLimiter{

    private final Long refillRate;
    private final Integer maxTokenCount = 10;
    private final ConcurrentHashMap<String,Integer> userTokens;
    private final   ConcurrentHashMap<String,Long> lastUpdatedTime;

    public TokenBucketRateLimiter(RateLimitType rateLimitType) {
        super(rateLimitType);
        userTokens = new ConcurrentHashMap<>();
        this.lastUpdatedTime = new ConcurrentHashMap<>();
        this.refillRate = 30 * 1000L; // for 30 sec 1 token will be refilled
    }

    @Override
    public boolean isRequestAllowed(User user) {
        synchronized (user.getUserId()) {
            Long now = System.currentTimeMillis();
            userTokens.putIfAbsent(user.getUserId(), maxTokenCount);
            lastUpdatedTime.putIfAbsent(user.getUserId(), now);
            Long prevTime = lastUpdatedTime.get(user.getUserId());
            while (prevTime < now) {
                prevTime += refillRate;
                userTokens.put(user.getUserId(), Math.min(maxTokenCount, userTokens.get(user.getUserId()) + 1));
            }
            lastUpdatedTime.put(user.getUserId(), prevTime);

            if (userTokens.get(user.getUserId()) > 0) {
                userTokens.compute(user.getUserId(), (K, V) -> V - 1);
                System.out.println("User has been allowed");
                return true;
            }
            throw new RuntimeException("User has exceeded your requests");
        }
    }
}

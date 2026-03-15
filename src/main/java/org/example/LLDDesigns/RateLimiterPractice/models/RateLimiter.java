package org.example.LLDDesigns.RateLimiterPractice.models;

import org.example.LLDDesigns.RateLimiter.enums.RateLimitType;

public abstract class RateLimiter {
    private final RateLimitType rateLimitType;


    public RateLimiter(RateLimitType rateLimitType) {
        this.rateLimitType = rateLimitType;
    }

    public RateLimitType getRateLimitType() {
        return rateLimitType;
    }

    public abstract boolean isRequestAllowed(User user);


}

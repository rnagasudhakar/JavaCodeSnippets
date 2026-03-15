package org.example.LLDDesigns.RateLimiterPractice.factory;

import org.example.LLDDesigns.RateLimiter.enums.RateLimitType;
import org.example.LLDDesigns.RateLimiterPractice.models.FixedWindowRateLimiter;
import org.example.LLDDesigns.RateLimiterPractice.models.RateLimiter;
import org.example.LLDDesigns.RateLimiterPractice.models.SlidingWindowRateLimiter;
import org.example.LLDDesigns.RateLimiterPractice.models.TokenBucketRateLimiter;

public class RateLimiterFactory {

    public static RateLimiter getRateLimiterBasedOnType(RateLimitType rateLimitType){
        switch (rateLimitType){
            case FIXED_WINDOW_RATE_LIMITER -> new FixedWindowRateLimiter(rateLimitType);
            case SLIDING_WINDOW_RATE_LIMITER -> new SlidingWindowRateLimiter(rateLimitType);
            default -> new TokenBucketRateLimiter(rateLimitType);
        }
        return null;
    }

}

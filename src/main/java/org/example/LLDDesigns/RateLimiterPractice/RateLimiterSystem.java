package org.example.LLDDesigns.RateLimiterPractice;

import org.example.LLDDesigns.RateLimiter.enums.RateLimitType;
import org.example.LLDDesigns.RateLimiterPractice.Dao.UserDao;
import org.example.LLDDesigns.RateLimiterPractice.factory.RateLimiterFactory;
import org.example.LLDDesigns.RateLimiterPractice.models.RateLimiter;
import org.example.LLDDesigns.RateLimiterPractice.models.User;

import java.util.concurrent.ConcurrentHashMap;

public class RateLimiterSystem {

    private final UserDao userDao;
    private final RateLimitType rateLimitType;
    private final RateLimiter rateLimiter;

    public RateLimiterSystem(UserDao userDao, RateLimitType rateLimitType) {
        this.userDao = userDao;
        this.rateLimitType = rateLimitType;
        this.rateLimiter = RateLimiterFactory.getRateLimiterBasedOnType(rateLimitType);
    }

    public void isRequestAllowed(String userId){
        User user = userDao.getUser(userId);
        if(user == null) throw new RuntimeException("User is not present");
        rateLimiter.isRequestAllowed(user);
    }


}

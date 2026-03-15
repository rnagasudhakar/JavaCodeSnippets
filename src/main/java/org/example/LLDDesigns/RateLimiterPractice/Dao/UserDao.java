package org.example.LLDDesigns.RateLimiterPractice.Dao;

import org.example.LLDDesigns.RateLimiterPractice.models.User;

import java.util.HashMap;

public class UserDao {
    private final HashMap<String, User> userHashMap = new HashMap<>();

    public void addUser(User user){
        userHashMap.put(user.getUserId(),user);
    }

    public User getUser(String userId){
        return userHashMap.get(userId);
    }
}

package org.example.LLDDesigns.RateLimiterPractice.models;

public class User {
    private String userId;
    private String userName;
    private Integer maxNumberOfRequests;

    public User(String userId, String userName, Integer maxNumberOfRequests) {
        this.userId = userId;
        this.userName = userName;
        this.maxNumberOfRequests = maxNumberOfRequests;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getMaxNumberOfRequests() {
        return maxNumberOfRequests;
    }

    public void setMaxNumberOfRequests(Integer maxNumberOfRequests) {
        this.maxNumberOfRequests = maxNumberOfRequests;
    }
}

package com.example.ratingdataservice.model;

import java.util.List;

public class UserRatings {
    public UserRatings() {
    }
    public List<Rating> getUserRatings() {
        return userRatings;
    }

    public void setUserRatings(List<Rating> userRatings) {
        this.userRatings = userRatings;
    }

    private List<Rating> userRatings;
}

package com.example.ratingdataservice.resource;

import com.example.ratingdataservice.model.Rating;
import com.example.ratingdataservice.model.UserRatings;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingInfoResource {
    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId){
     return new Rating(movieId,4);
    }

    @RequestMapping("users/{userId}")
    public UserRatings getUserRating(@PathVariable("userId") String userId) {

        List<Rating> ratings = Arrays.asList(
                new Rating("1234", 4),
                new Rating("5678", 3)
        );
        UserRatings userRatings = new UserRatings();
        userRatings.setUserRatings(ratings);
        return userRatings ;
    }
}

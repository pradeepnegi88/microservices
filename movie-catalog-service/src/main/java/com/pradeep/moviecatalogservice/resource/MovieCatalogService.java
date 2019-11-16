package com.pradeep.moviecatalogservice.resource;

import com.pradeep.moviecatalogservice.model.CatalogItem;
import com.pradeep.moviecatalogservice.model.Movie;
import com.pradeep.moviecatalogservice.model.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    WebClient.Builder webClientBuilder;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalogs(@PathVariable("userId") String userId) {


        List<Rating> ratings = Arrays.asList(
                new Rating("1234", 4),
                new Rating("5678", 3)
        );

        return ratings.stream().map(rating -> {
           Movie movie =  webClientBuilder.build().
                    get().
                    uri("http://localhost:8081/movie/" + rating.getMovieId()).
                    retrieve().
                    bodyToMono(Movie.class).
                     block();
//            Movie movie = restTemplate.getForObject("http://localhost:8081/movie/" + rating.getMovieId(), Movie.class);
           return new CatalogItem(movie.getName(), "description", rating.getRating());
        }).collect(Collectors.toList());

    }

}

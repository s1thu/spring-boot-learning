package com.sithu.movierecommendersysspring.REST;

import com.sithu.movierecommendersysspring.lesson.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class RecommendationController {

    @GetMapping("/movies")
    public List<RestMovie> getAllMovies(){
       return Arrays.asList(
               new RestMovie(1,"Nemo",10.0),
               new RestMovie(2,"Zero2",9.0)
       );
    }
}

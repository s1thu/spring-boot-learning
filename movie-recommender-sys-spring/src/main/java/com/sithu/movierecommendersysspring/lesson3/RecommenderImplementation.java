package com.sithu.movierecommendersysspring.lesson3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class RecommenderImplementation {

    //@Autowired => Dependencies
    @Autowired
    @Qualifier("CBF")
    private Filter filter;

    public String[] recommendMovies(){
        return filter.recommendMovies();
    }
}

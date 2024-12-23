package com.sithu.movierecommendersysspring.lesson3;

import org.springframework.stereotype.Component;

@Component
public interface Filter {
    public String[] recommendMovies();
}

package com.sithu.movierecommendersysspring.lesson;

import org.springframework.stereotype.Component;

@Component
public interface Filter {
    public String[] recommendMovies();
}

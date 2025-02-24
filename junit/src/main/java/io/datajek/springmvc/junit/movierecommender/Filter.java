package io.datajek.springmvc.junit.movierecommender;

import org.springframework.stereotype.Component;

@Component
public interface Filter {
    String[] getRecommendation();
}

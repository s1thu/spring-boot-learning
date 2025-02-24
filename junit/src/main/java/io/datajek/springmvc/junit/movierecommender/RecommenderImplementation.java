package io.datajek.springmvc.junit.movierecommender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RecommenderImplementation {

    @Autowired
    private Filter filter;

    public RecommenderImplementation(Filter filter) {
        super();
        this.filter = filter;
    }

    public String[] getRecommendation(){
        return filter.getRecommendation();
    }
}

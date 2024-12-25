package com.sithu.movierecommendersysspring.lesson;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class RecommenderImplementation {

    //@Autowired => Dependencies
    @Autowired
    @Qualifier("CBF")
    private Filter filter;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public String[] recommendMovies(){
        return filter.recommendMovies();
    }

    @Autowired
    @Qualifier("CBF")
    public void setFilter(Filter filter) {
        logger.info("In RecommenderImplementation setter method.. dependency injection");
        this.filter = filter;
    }

    @PostConstruct
    public void postConstruct(){
        logger.info("In RecommenderImplementation postConstruct");
    }

    @PreDestroy
    public void preDestory(){
        logger.info("In RecommenderImplementation preDestory");
    }
}

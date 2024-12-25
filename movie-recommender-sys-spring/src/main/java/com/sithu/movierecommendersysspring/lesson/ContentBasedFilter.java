package com.sithu.movierecommendersysspring.lesson;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("CBF")
public class ContentBasedFilter implements Filter{

    //manage objects and dependencies, Spring requires info about 3 things
    //1. Beans
    //2. Dependencies
    //3. Location of Beans

    private static int instances = 0;

    @Autowired
    private Movie movie;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public ContentBasedFilter(){
        super();
        instances++;
        System.out.println("ContentBasedFilter instances called!");
        logger.info("In ContentBasedFilter constructor method");
    }

    @PostConstruct
    private void postConstruct(){
        logger.info("In ContentBasedFilter postConstruct");
    }

    public Movie getMovie(){
        return movie;
    }

    public static int getInstances(){
        return instances;
    }

    //@Component => Spring to create and manage objects
    @Override
    public String[] recommendMovies() {
        return new String[]{"contentbasedFilter1","contentbasedFilter2"};
    }

}

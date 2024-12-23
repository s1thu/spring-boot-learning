package com.sithu.movierecommendersysspring.lesson3;

import org.springframework.stereotype.Component;

@Component("CBF")
public class ContentBasedFilter implements Filter{

    //manage objects and dependencies, Spring requires info about 3 things
    //1. Beans
    //2. Dependencies
    //3. Location of Beans

    //@Component => Spring to create and manage objects
    @Override
    public String[] recommendMovies() {
        return new String[]{"contentbasedFilter1","contentbasedFilter2"};
    }
}

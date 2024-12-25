package com.sithu.movierecommendersysspring.lesson;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE,proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Movie {

    private static int instances = 0;
    private int id;
    private String name;
    private String genre;
    private String producer;

    public Movie(){
        instances++;
        System.out.println("Movie instructor is called!");
    }

    public static int getInstances(){
        return Movie.instances;
    }

    @PostConstruct
    public void init(){
        System.out.println("Movie constructor is called!");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Movie pre-destroy is called!");
    }
}

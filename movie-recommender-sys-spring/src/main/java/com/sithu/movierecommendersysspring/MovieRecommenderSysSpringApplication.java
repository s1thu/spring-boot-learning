package com.sithu.movierecommendersysspring;

import com.sithu.movierecommendersysspring.lesson3.RecommenderImplementation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class MovieRecommenderSysSpringApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MovieRecommenderSysSpringApplication.class, args);
        RecommenderImplementation recommenderImpl = context.getBean(RecommenderImplementation.class);
        String[] result = recommenderImpl.recommendMovies();
        System.out.println(Arrays.toString(result));
    }

}

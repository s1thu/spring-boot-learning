package io.datajek.springmvc.junit;

import io.datajek.springmvc.junit.movierecommender.RecommenderImplementation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class JunitApplication {
    public static void main(String[] args) {
        ApplicationContext appContext= SpringApplication.run(JunitApplication.class, args);
        RecommenderImplementation recommenderImplementation = appContext.getBean(RecommenderImplementation.class);
        System.out.println(Arrays.toString(recommenderImplementation.getRecommendation()));
    }

}

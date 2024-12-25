package com.sithu.movierecommendersysspring;

import com.sithu.movierecommendersysspring.lesson.ContentBasedFilter;
import com.sithu.movierecommendersysspring.lesson.Movie;
import com.sithu.movierecommendersysspring.lesson.RecommenderImplementation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class MovieRecommenderSysSpringApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MovieRecommenderSysSpringApplication.class, args);
        RecommenderImplementation recommenderImpl = context.getBean(RecommenderImplementation.class);
//        String[] result = recommenderImpl.recommendMovies();
        System.out.println(recommenderImpl);

        //Singleton Bean Scope
        ContentBasedFilter contentBasedFilter = context.getBean(ContentBasedFilter.class);
        ContentBasedFilter contentBasedFilter2 = context.getBean(ContentBasedFilter.class);
        ContentBasedFilter contentBasedFilter3 = context.getBean(ContentBasedFilter.class);

        System.out.println(contentBasedFilter);
        System.out.println(contentBasedFilter2);
        System.out.println(contentBasedFilter3);
//        System.out.println(Arrays.toString(result));

        Movie movie1 = contentBasedFilter.getMovie();
        Movie movie2 = contentBasedFilter.getMovie();
        Movie movie3 = contentBasedFilter.getMovie();

        System.out.println("\nMovie bean with prototype scope with Singleton scope contentbasedFilter");
        System.out.println(movie1);
        System.out.println(movie2);
        System.out.println(movie3);

        System.out.println("\nMovie bean with prototype scope");
        Movie movie4 = context.getBean(Movie.class);
        Movie movie5 = context.getBean(Movie.class);
        Movie movie6 = context.getBean(Movie.class);

        System.out.println(movie4);
        System.out.println(movie5);
        System.out.println(movie6);

        System.out.println("Number of instances create for ContentBasedFilter "+ ContentBasedFilter.getInstances() );
        System.out.println("Number of instances create for Movie "+ Movie.getInstances() );

    }

}

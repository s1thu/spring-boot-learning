package com.sithu.lesson1;

import java.util.Arrays;

public class MovieRecommenderSystemApp {
    public static void main(String[] args) {
        RecommenderImplementation contentBased = new RecommenderImplementation(new ContentBasedFilter());
        System.out.println("This is from content based filter. =====>");
        System.out.println(Arrays.toString(contentBased.recommendMovies()));

        RecommenderImplementation collaborative = new RecommenderImplementation(new ContentBasedFilter());
        System.out.println("This is from Collaborative filter. =====>");
        System.out.println(Arrays.toString(collaborative.recommendMovies()));
    }
}

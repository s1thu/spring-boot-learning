package com.sithu.movierecommendersysspring;

import com.sithu.movierecommendersysspring.challenge.DiscountService;
import com.sithu.movierecommendersysspring.lesson.ContentBasedFilter;
import com.sithu.movierecommendersysspring.lesson.Movie;
import com.sithu.movierecommendersysspring.lesson.RecommenderImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

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

        DiscountService discountService = new DiscountService();
        System.out.println("Applying discounts:");

        // Initialing the original price
        double originalPrice = 100.0;
        System.out.println("Original Price: $" + originalPrice);

        // Apply default discount
        double defaultDiscountedPrice = discountService.applyDefaultDiscount(originalPrice);
        System.out.println("Price after Default Discount: $" + defaultDiscountedPrice);

        // Apply membership discount
        double membershipDiscountedPrice = discountService.applyMembershipDiscount(originalPrice);
        System.out.println("Price after Membership Discount: $" + membershipDiscountedPrice);

        // Apply bundle discount
        double bundleDiscountedPrice = discountService.applyBundleDiscount(originalPrice);
        System.out.println("Price after Bundle Discount: $" + bundleDiscountedPrice);

        // Apply all discounts
        double fullyDiscountedPrice = discountService.applyAllDiscounts(originalPrice);
        System.out.println("Price after Full Discount: $" + fullyDiscountedPrice);


    }

}

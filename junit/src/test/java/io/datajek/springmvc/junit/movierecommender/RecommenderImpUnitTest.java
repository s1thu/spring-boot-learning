package io.datajek.springmvc.junit.movierecommender;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RecommenderImpUnitTest {

    @Test
    void testRecommendMovies_withCartoonBasedFilter() {
        RecommenderImplementation recommenderImpl = new RecommenderImplementation(
                new CartoonBasedFilter());
        //2. Call method on the bean
        String[] actualResult = recommenderImpl.getRecommendation();
        //3. Check if the result is as expected
        String[] expectedResult = new String[] {"Nemo","Dori"};
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void testRecommendMovies_withActionBasedFilter() {
        RecommenderImplementation recommenderImpl = new RecommenderImplementation(
                new ActionBasedFilter());
        //2. Call method on the bean
        String[] actualResult = recommenderImpl.getRecommendation();
        //3. Check if the result is as expected
        String[] expectedResult = new String[] {"John Wick 1","John Wick 2","John Wick 3"};
        assertArrayEquals(expectedResult, actualResult);
    }

}

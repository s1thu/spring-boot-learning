package io.datajek.springmvc.junit.movierecommender;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RecommenderImpSpringBootUnitTest {

    @Autowired
    private RecommenderImplementation recommenderImplementation;

    @Test
    void testRecommendMovies_withCartoonFilter(){
        assertArrayEquals(new String[]{"Nemo","Dori"},recommenderImplementation.getRecommendation());
    }
}

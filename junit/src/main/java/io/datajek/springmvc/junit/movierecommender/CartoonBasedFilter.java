package io.datajek.springmvc.junit.movierecommender;

import org.springframework.stereotype.Component;

@Component
public class CartoonBasedFilter implements Filter{

    @Override
    public String[] getRecommendation() {
        return new String[]{"Nemo","Dori"};
    }
}

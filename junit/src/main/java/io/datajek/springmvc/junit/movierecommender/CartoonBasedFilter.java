package io.datajek.springmvc.junit.movierecommender;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CartoonBasedFilter implements Filter{

    @Override
    public String[] getRecommendation() {
        return new String[]{"Nemo","Dori"};
    }
}

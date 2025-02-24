package io.datajek.springmvc.junit.movierecommender;

import org.springframework.stereotype.Component;

@Component
public class ActionBasedFilter implements Filter{

    @Override
    public String[] getRecommendation() {
        return new String[]{"John Wick 1","John Wick 2","John Wick 3"};
    }
}

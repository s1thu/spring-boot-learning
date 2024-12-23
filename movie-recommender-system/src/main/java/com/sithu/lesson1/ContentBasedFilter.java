package com.sithu.lesson1;

public class ContentBasedFilter implements  Filter{

    @Override
    public String[] getRecommendation() {
        return new String[]{"Nemo","Astro Boy","Dory"};
    }
}

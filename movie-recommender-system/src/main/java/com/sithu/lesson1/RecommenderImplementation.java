package com.sithu.lesson1;

public class RecommenderImplementation {

    //use interface as type variable
    private Filter filter;

    public RecommenderImplementation(Filter filter) {
        this.filter = filter;
    }

    public String[] recommendMovies(){

        //this is tight coupling
        //if we want to change the type of filer we need to change every time in this code
//        ContentBasedFilter contentBasedFilter = new ContentBasedFilter();
//        String[] result = contentBasedFilter.getRecommendation("Hello");
//        return result;

        return filter.getRecommendation();

    }
}

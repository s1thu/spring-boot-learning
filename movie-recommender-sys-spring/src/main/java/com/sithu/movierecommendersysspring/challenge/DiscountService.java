package com.sithu.movierecommendersysspring.challenge;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DiscountService {
    private final DiscountStrategy discountDEF,discountBDS,discountMDS;
    private final List<DiscountStrategy> discountStrategies;

    public DiscountService(){
        this.discountDEF = new DefaultDiscountStrategy();
        this.discountBDS = new BundleDiscountStrategy();
        this.discountMDS = new MembershipDiscountStrategy();
        this.discountStrategies = Arrays.asList(discountDEF, discountBDS, discountMDS);
    }

    public double applyDefaultDiscount(double originalPrice){
        return discountDEF.applyDiscount(originalPrice);
    }

    public double applyBundleDiscount(double originalPrice){
        return discountBDS.applyDiscount(originalPrice);
    }

    public double applyMembershipDiscount(double originalPrice){
        return discountMDS.applyDiscount(originalPrice);
    }

    public double applyAllDiscounts(double originalPrice){
        double discountPrice = originalPrice;
        for(DiscountStrategy discountStrategy : discountStrategies){
            discountPrice = discountStrategy.applyDiscount(discountPrice);
        }
        return discountPrice;
    }
}

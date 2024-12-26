package com.sithu.movierecommendersysspring.challenge;

import org.springframework.stereotype.Component;

@Component
public class BundleDiscountStrategy implements DiscountStrategy {
    @Override
    public double applyDiscount(double originalPrice) {
        return originalPrice * 0.9;
    }
}

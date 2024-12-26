package com.sithu.movierecommendersysspring.challenge;

import org.springframework.stereotype.Component;

@Component
public class MembershipDiscountStrategy implements DiscountStrategy{
    @Override
    public double applyDiscount(double originalPrice) {
        return originalPrice * 0.85;
    }
}

package com.sithu.movierecommendersysspring.challenge;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class DefaultDiscountStrategy implements DiscountStrategy{
    @Override
    public double applyDiscount(double originalPrice) {
        return originalPrice * 0.95;//5% discount
    }
}

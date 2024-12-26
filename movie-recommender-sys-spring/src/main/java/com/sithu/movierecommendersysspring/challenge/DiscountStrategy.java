package com.sithu.movierecommendersysspring.challenge;

import org.springframework.stereotype.Component;

@Component
public interface DiscountStrategy {
    double applyDiscount(double originalPrice);
}

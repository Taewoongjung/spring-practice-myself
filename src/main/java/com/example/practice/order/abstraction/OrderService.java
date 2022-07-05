package com.example.practice.order.abstraction;

import com.example.practice.order.object.Order;

public interface OrderService {
    Order createOrder(Long carId, Long memberId, String itemName, int itemPrice);
}

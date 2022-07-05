package com.example.practice.order.service;

import com.example.practice.car_domain.car.object.Car;
import com.example.practice.car_domain.car.repository.CarMemoryRepository;
import com.example.practice.contract.car.CarType;
import com.example.practice.member_domain.member.abstraction.MemberRepository;
import com.example.practice.member_domain.member.object.Member;
import com.example.practice.order.abstraction.OrderService;
import com.example.practice.order.object.Order;
import com.example.practice.policy.discount.DiscountPolicy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final DiscountPolicy discountPolicy;
    private final MemberRepository memberRepository;
    private final CarMemoryRepository carMemoryRepository;

    @Override
    public Order createOrder(Long carId, Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);

        Car found = carMemoryRepository.findById(carId);

        int discount = 0;
        if ((found.getCarType() == CarType.BUS) || (found.getCarType() == CarType.TRUCK)) {

            int discountPrice = discountPolicy.discount(member, itemPrice);
            discount += discountPrice;
            return new Order(memberId, itemName, itemPrice, discount);
        }
        return new Order(memberId, itemName, itemPrice, discount);
    }
}

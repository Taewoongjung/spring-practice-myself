package com.example.practice.order.service;

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

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}

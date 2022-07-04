package com.example.practice.policy.discount;

import com.example.practice.member_domain.member.object.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);
}

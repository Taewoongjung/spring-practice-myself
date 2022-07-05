package com.example.practice.order.service;

import com.example.practice.car_domain.car.object.Car;
import com.example.practice.car_domain.car.repository.CarMemoryRepository;
import com.example.practice.contract.car.CarFuelOpen;
import com.example.practice.contract.car.CarOnOff;
import com.example.practice.contract.car.CarType;
import com.example.practice.contract.member.Grade;
import com.example.practice.member_domain.member.abstraction.MemberRepository;
import com.example.practice.member_domain.member.object.Member;
import com.example.practice.member_domain.member.repository.MemoryMemberRepository;
import com.example.practice.order.object.Order;
import com.example.practice.policy.discount.DiscountPolicy;
import com.example.practice.policy.discount.FixDiscountPolicy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    @DisplayName("주문을 할 수 있다.")
    void createOrder() {
        // given
        CarMemoryRepository carMemoryRepository = new CarMemoryRepository();
        MemberRepository memberRepository = new MemoryMemberRepository();
        DiscountPolicy discountPolicy = new FixDiscountPolicy();

        carMemoryRepository.save(new Car(1L, "GV80", CarType.SUV, "2022", 70, CarOnOff.ON, CarFuelOpen.OPEN, 70000000000L));

        memberRepository.save(new Member(1L, "TWJ", 29, Grade.VIP, 1L));

        OrderServiceImpl orderService = new OrderServiceImpl(discountPolicy, memberRepository, carMemoryRepository);

        // when
        Order actual = orderService.createOrder(1L, 1L, "휘발유", 10000);

        // then
        assertThat(actual).isNotNull();
    }

    @Test
    @DisplayName("버스나 트럭이 아니면 할인이 된다.")
    void discountTest1() {
        // given
        CarMemoryRepository carMemoryRepository = new CarMemoryRepository();
        MemberRepository memberRepository = new MemoryMemberRepository();
        DiscountPolicy discountPolicy = new FixDiscountPolicy();

        carMemoryRepository.save(new Car(1L, "GV80", CarType.SUV, "2022", 70, CarOnOff.ON, CarFuelOpen.OPEN, 70000000000L));

        memberRepository.save(new Member(1L, "TWJ", 29, Grade.VIP, 1L));

        OrderServiceImpl orderService = new OrderServiceImpl(discountPolicy, memberRepository, carMemoryRepository);

        // when
        Order actual = orderService.createOrder(1L,  1L, "휘발유", 10000);

        // then
        assertThat(actual.getDiscountPrice()).isEqualTo(0);
    }

    @Test
    @DisplayName("버스나 트럭이면 FixDiscountPolicy 로 할인이 된다.")
    void discountTest2() {
        // given
        CarMemoryRepository carMemoryRepository = new CarMemoryRepository();
        MemberRepository memberRepository = new MemoryMemberRepository();
        DiscountPolicy discountPolicy = new FixDiscountPolicy();

        carMemoryRepository.save(new Car(1L, "Explorer", CarType.BUS, "2022", 700, CarOnOff.ON, CarFuelOpen.CLOSED, 1000000000000L));

        memberRepository.save(new Member(1L, "TWJ", 29, Grade.VIP, 1L));

        OrderServiceImpl orderService = new OrderServiceImpl(discountPolicy, memberRepository, carMemoryRepository);

        // when
        Order actual = orderService.createOrder(1L,  1L, "휘발유", 10000);

        // then
        assertThat(actual.getDiscountPrice()).isEqualTo(1000);
    }
}

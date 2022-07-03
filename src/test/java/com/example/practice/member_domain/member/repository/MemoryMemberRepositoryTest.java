package com.example.practice.member_domain.member.repository;

import com.example.practice.AutoAppConfig;
import com.example.practice.car_domain.car.object.Car;
import com.example.practice.car_domain.car.repository.CarMemoryRepository;
import com.example.practice.contract.car.CarFuelOpen;
import com.example.practice.contract.car.CarOnOff;
import com.example.practice.contract.car.CarType;
import com.example.practice.contract.member.Grade;
import com.example.practice.member_domain.member.abstraction.MemberRepository;
import com.example.practice.member_domain.member.object.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    @Test
    @DisplayName("MemoryMemberRepositoryTest 는 새로운 값을 가질 수 있다.")
    void saveTest() {
        // given
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        MemberRepository memberRepository = ac.getBean(MemoryMemberRepository.class);
        CarMemoryRepository carMemoryRepository = ac.getBean(CarMemoryRepository.class);
        Long carId = 1L;
        Long memberId = 1L;
        carMemoryRepository.save(new Car(carId, "GV80", CarType.SUV, "2022", 70, CarOnOff.OFF, CarFuelOpen.OPEN, 70000000000L));
        memberRepository.save(new Member(memberId, "TWJ", 29, Grade.VIP, carId));

        // when
        Member actual = memberRepository.findById(memberId);

        // then
        assertThat(actual).isNotNull();
        assertThat(actual.getId()).isEqualTo(memberId);
        assertThat(actual.getName()).isEqualTo("TWJ");
        assertThat(actual.getAge()).isEqualTo(29);
        assertThat(actual.getGrade()).isEqualTo(Grade.VIP);
        assertThat(actual.getCarId()).isEqualTo(carId);
    }
}

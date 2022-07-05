package com.example.practice.member_domain.member.service;

import com.example.practice.car_domain.car.object.Car;
import com.example.practice.car_domain.car.repository.CarMemoryRepository;
import com.example.practice.contract.car.CarFuelOpen;
import com.example.practice.contract.car.CarOnOff;
import com.example.practice.contract.car.CarType;
import com.example.practice.contract.member.Grade;
import com.example.practice.member_domain.member.object.Member;
import com.example.practice.member_domain.member.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MemberServiceImplTest {

    @Test
    @DisplayName("유저를 등록할 수 있다.")
    void joinMember() {
        // given
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        CarMemoryRepository carMemoryRepository = new CarMemoryRepository();

        Long carId = 1L;
        Long memberId = 1L;

        carMemoryRepository.save(new Car(carId, "GV80", CarType.SUV, "2022", 70, CarOnOff.ON, CarFuelOpen.OPEN, 70000000000L));

        MemberServiceImpl memberServiceImpl = new MemberServiceImpl(memberRepository);

        // when
        memberServiceImpl.join(new Member(memberId, "TaeWoongJung", 29, Grade.VIP, carId));
        Member actual = memberRepository.findById(memberId);

        // then
        assertThat(actual).isNotNull();
        assertThat(actual.getId()).isEqualTo(1L);
        assertThat(actual.getName()).isEqualTo("TaeWoongJung");
        assertThat(actual.getAge()).isEqualTo(29);
        assertThat(actual.getGrade()).isEqualTo(Grade.VIP);
        assertThat(actual.getCarId()).isEqualTo(carId);
    }

    @Test
    @DisplayName("유저를 찾을 수 있다.")
    void findMember() {
        // given
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        CarMemoryRepository carMemoryRepository = new CarMemoryRepository();

        Long carId = 1L;
        Long memberId = 1L;

        carMemoryRepository.save(new Car(carId, "GV80", CarType.SUV, "2022", 70, CarOnOff.ON, CarFuelOpen.OPEN, 70000000000L));
        memberRepository.save(new Member(memberId, "TaeWoongJung", 29, Grade.VIP, carId));

        MemberServiceImpl memberServiceImpl = new MemberServiceImpl(memberRepository);

        // when
        Member actual = memberServiceImpl.findMember(1L);

        // then
        assertThat(actual).isNotNull();
        assertThat(actual.getId()).isEqualTo(1L);
        assertThat(actual.getName()).isEqualTo("TaeWoongJung");
        assertThat(actual.getAge()).isEqualTo(29);
        assertThat(actual.getGrade()).isEqualTo(Grade.VIP);
        assertThat(actual.getCarId()).isEqualTo(carId);
    }
}
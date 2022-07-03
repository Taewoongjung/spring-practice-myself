package com.example.practice.member_domain.member.object;

import com.example.practice.contract.member.Grade;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Member {

    private Long id;
    private String name;
    private int age;
    private Grade grade;
    private Long carId; // 소유하고 있는 차 id

    public Member(Long id, String name, int age, Grade grade, Long carId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.carId = carId;
    }
}

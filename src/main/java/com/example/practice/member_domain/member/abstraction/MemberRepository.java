package com.example.practice.member_domain.member.abstraction;

import com.example.practice.member_domain.member.object.Member;

public interface MemberRepository {
    void save(Member member);

    Member findById(Long memberId);
}

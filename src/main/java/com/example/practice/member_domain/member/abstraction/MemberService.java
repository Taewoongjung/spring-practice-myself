package com.example.practice.member_domain.member.abstraction;

import com.example.practice.member_domain.member.object.Member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}

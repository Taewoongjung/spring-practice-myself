package com.example.practice.member_domain.member.service;

import com.example.practice.member_domain.member.abstraction.MemberService;
import com.example.practice.member_domain.member.object.Member;
import com.example.practice.member_domain.member.repository.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemoryMemberRepository memberRepository;

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}

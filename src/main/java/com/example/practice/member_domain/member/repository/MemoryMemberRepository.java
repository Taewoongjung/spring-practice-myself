package com.example.practice.member_domain.member.repository;

import com.example.practice.member_domain.member.abstraction.MemberRepository;
import com.example.practice.member_domain.member.object.Member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}

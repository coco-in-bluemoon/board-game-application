package com.example.boardGameApplication.repository;

import com.example.boardGameApplication.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    void save(Member member);
    Optional<Member> findByMemberId(Long memberId);
    Optional<Member> findByMemberName(String memberName);
    List<Member> findAll();
}

package com.example.boardGameApplication.service;

import com.example.boardGameApplication.domain.Member;

import java.util.List;

public interface MemberService {
    Member join(Member member);
    Member findMember(Long memberId);
    List<Member> findAllMember();
}

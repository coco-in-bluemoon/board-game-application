package com.example.boardGameApplication.service;

import com.example.boardGameApplication.domain.Member;
import com.example.boardGameApplication.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Member join(Member member) {
        validateDuplicatedMember(member);
        memberRepository.save(member);
        return member;
    }

    private void validateDuplicatedMember(Member member) {
        memberRepository.findByMemberName(member.getMemberName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 등록된 사용자입니다.");
                });
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findByMemberId(memberId).get();
    }

    @Override
    public List<Member> findAllMember() {
        return memberRepository.findAll();
    }
}

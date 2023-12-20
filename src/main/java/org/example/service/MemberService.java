package org.example.service;

import org.example.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional

@Transactional

@Service
public class MemberService {
    private final MemberRepository memberRepository;

   @Autowired

   private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository=memberRepository;
    }
    /**
     * 회원가입
     */
    public Long join(Member member) {
        validateDuplicateMember(member); //중복 회원 검증
        Member save = memberRepository.save((Member) member);
        return (long) member.getModifiers();
    }
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
    /**
     * 전체 회원 조회
     */
    public List<org.example.domain.Member> findMembers() {
        return memberRepository.findAll();
    }
    public Optional<org.example.domain.Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}

package org.example.repository;

import java.lang.reflect.Member;
import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    org.example.domain.Member save(org.example.domain.Member member);

    Member save();

    Member save(Member member); // 회원 저장
    Optional<org.example.domain.Member> findById(Long id);
    Optional<org.example.domain.Member> findByName(String name);
    List<org.example.domain.Member> findAll(); //저장한 모든 회원 리스트 반환
}

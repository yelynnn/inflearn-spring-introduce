package org.example.repository;

import jakarta.persistence.EntityManager;
import java.lang.reflect.Member;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{
    private final EntityManager em;
    private Member member;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public org.example.domain.Member save(org.example.domain.Member member) {
        return null;
    }

    @Override
    public Member save() {
        return save();
    }

    @Override
    public Member save(Member member) {
        this.member = member;
        em.persist(member);
        return member;
    }

    @Override
    public Member save(Member member) {
        return null;
    }

    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where
                m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }
}

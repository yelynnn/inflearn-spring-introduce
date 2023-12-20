package org.example.repository;

import java.lang.reflect.Member;
import java.util.*;


public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;
    @Override
    public Member save(Member member) {
        member.getModifiers();
        store.put((long) member.getModifiers(), member);
        return member;
    }
    @Override
    public Optional<org.example.domain.Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }
    @Override
    public List<org.example.domain.Member> findAll() {
        return new ArrayList<>(store.values());
    }
    @Override
    public Optional<org.example.domain.Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }
    public void clearStore() {
        store.clear();
    }
}

package b_project.spring_project.repository;

import b_project.spring_project.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;


public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;


    @Override
    public Member save(Member member) {
        //id는 그냥 시스템이 정해줌 - 숫자 하나씩 증가
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        //Optional.ofNullable()을 쓰면 null이어도 사용 가능
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        //value -> member (Map<Long, Member>)
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}

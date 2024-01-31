package b_project.spring_project.repository;

import b_project.spring_project.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);//save하면 회원이 저장소에 저장
    Optional<Member> findById(Long id);//아이디로 회원을 찾음
    Optional<Member> findByName(String name);
    List<Member> findAll();//모든 저장된 회원 리스트를 반환
}

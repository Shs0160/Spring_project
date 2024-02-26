package b_project.spring_project.repository;

import b_project.spring_project.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository{
    @Override
    Optional<Member> findByName(String name);
}

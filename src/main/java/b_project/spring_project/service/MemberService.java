package b_project.spring_project.service;

import b_project.spring_project.domain.Member;
import b_project.spring_project.repository.MemberRepository;
import b_project.spring_project.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//컴포넌트 스캔
// 스프링 컨테이너에 스프링 빈 등록
public class MemberService {
    private final MemberRepository memberRepository;

    //외부에서 매개변수를 넣어주는 것 = DI
    //DI -> 생성자 주입 방법
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    //회원 가입
    public Long join(Member member){
        //같은 이름 중복 회원 불가능
        vaildateDuplicateMember(member); //중복회원 검증

        memberRepository.save(member);
        return member.getId();
    }

    private void vaildateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent(member1 -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}

package b_project.spring_project;

import b_project.spring_project.repository.MemberRepository;
import b_project.spring_project.repository.MemoryMemberRepository;
import b_project.spring_project.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 컴포넌트 스캔 말고 직접 스프링 빈 등록
 */
@Configuration
public class SpringConfig {

    //스프링 빈 등록
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    //이런식으로 직접 설정하면 나중에 저장소를 DB로 연결할 때 이 코드만 수정해주면 .
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
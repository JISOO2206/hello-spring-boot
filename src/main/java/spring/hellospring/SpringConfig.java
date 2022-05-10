package spring.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.hellospring.repository.MemberRepository;
import spring.hellospring.repository.MemoryMemberRepository;
import spring.hellospring.service.MemberService;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }
    /*
        @Configuration을 읽고 해당 @Bean을 보고
        Spring Bean에 등록하라는 뜻으로 인식한다.
     */

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    /*
        spring이 run 상태가 되면 두 개 모두 Spring Bean에 등록한 후
        등록되어 있는 memberRepository를 memberService에 넣어줌

        Controller의 경우는 기존에 하던 방법대로 @Controller를 적용 후
        AutoWired를 생성자에 적용하여 Service 연결하면 된다.
     */


}

package spring.hellospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import spring.hellospring.domain.Member;
import spring.hellospring.service.MemberService;

import java.util.List;

/*
    @Component : 이 어노테이션이 붙어있으면,
    컨테이너가 이 어노테이션이 붙은 모든 객체를 생성해서 컨테이너에 등록한다.
 */

//@Controller : 이 어노테이션이 있으며 spring이 뜰 때 스프링 컨테이너가
//Controller을 생성해서 관리함.
@Controller
public class MemberController {

    /*
        new 생성자를 사용해서 사용하다보면
        다른 Controller도 MemberService()라는 객체를 사용할 수 있게 되는
        문제가 발생한다.
     */
    private final MemberService memberService;
    // 특별히 성격이 다른 기능이 없기 때문에 공용해서 사용하면 된다.
    // 그래서 이걸 Spring container에게 등록하고 쓰면 된다.

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    // MemberController가 spring Container에 의해서 뜰 때
    // MemberController 생성자를 연결시켜준다.
    // spring에 등록되어 있는 MemberService 객체를 가져다가 넣어줌.


    /*
        그럼 아무 class에 Component 어노테이션을 붙어도 모두 인식할까?
        기본적으로 안 된다.
        HelloSpringApplication이 포함된 최상위 package 내에 있는
        class, interface들만 적용이 가능하다
     */

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }
    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    //url은 같지만 get이냐 post냐에 따라서 다르게 사용할 수 있음.

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}

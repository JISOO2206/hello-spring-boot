package spring.hellospring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.hellospring.domain.Member;
import spring.hellospring.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    // MemberService를 Spring이 생성할 때,
    // 이 class를 service으로 등록하면서 생성자를 호출한다.
    // 이 때 AutoWired가 있으면 MemberRepository가 필요하다는 걸 알고
    // spring에 있는 MemberRepository를 가져다 넣어준다.


    /*
        회원 가입
     */
    public Long join(Member member){
        // 같은 이름이 있는 중복 회원X
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getMemberId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /*
    *   전체 회원 조회
    * */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}

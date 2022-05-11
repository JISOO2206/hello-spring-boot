package spring.hellospring.repository;

import org.springframework.stereotype.Repository;
import spring.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{


    private static Map<Long, Member> store = new HashMap<>();
    // 실무에서는 동시성 문제가 있을 수 있어서
    // 공유되는 변수일때는 컨크루트? HashMap을 사용해야 함.

    private static long sequence = 0L;
    // 실무에서는 어텀롱을 사용해야 함.

    @Override
    public Member save(Member member) {
        member.setMemberId(++sequence);
        store.put(member.getMemberId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long memberId) {
        return Optional.ofNullable(store.get(memberId));
        // null이 반환될 가능성이 있으면 optional.ofNullable()로 감싸준다.
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                //filter을 사용해 파라미터로 넘어온 name과 같은지 확인.
                .findAny();
                //찾을 때까지 루프를 돌리고 찾으면 반환을 한다.
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}

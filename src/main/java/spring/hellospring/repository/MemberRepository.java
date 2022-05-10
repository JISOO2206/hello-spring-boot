package spring.hellospring.repository;

import spring.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);
    Optional<Member> findById(Long member_idx);
    Optional<Member> findByName(String name);
    List<Member> findAll();



}

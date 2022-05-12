package spring.hellospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.hellospring.domain.Member;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    //Native SQL
    //select m from Member m where m.name = ?
    //JPA가 실행하는 해당 메서드의 쿼리문.
    @Override
    Optional<Member> findByName(String name);
}

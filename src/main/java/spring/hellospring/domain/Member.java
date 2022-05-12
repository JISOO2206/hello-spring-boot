package spring.hellospring.domain;

import javax.persistence.*;

@Entity
public class Member {

    @Id @Column(name = "id") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;    //고객이 정하는 id가 아니라 시스템이 정하는 id

    @Column(name = "name")
    private String name;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

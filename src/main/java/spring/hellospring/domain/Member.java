package spring.hellospring.domain;

public class Member {

    private Long member_idx;    //고객이 정하는 id가 아니라 시스템이 정하는 id
    private String name;

    public Long getmember_idx() {
        return member_idx;
    }

    public void setmember_idx(Long member_idx) {
        this.member_idx = member_idx;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package study.datajpa.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "username", "age"}) // 객체 출력시 형태 -> team 포함시 무한 루프될 수도
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String username;
    private int age;

    @ManyToOne
    @JoinColumn(name="team_id")
    private Team team;


    public Member(String username) {
        this.username = username;
    }

    public void changeUsername(String username) {
        this.username = username;
        team.getMembers().add(this);
    }
}

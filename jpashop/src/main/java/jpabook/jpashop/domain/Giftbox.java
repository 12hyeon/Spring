package jpabook.orignal_jpashop.domain;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter @Setter
public class GiftBox {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gift_box_id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private jpabook.jpashop.domain.Member member; // giftBox <- member에게 넣어주는 구조

    @OneToMany(mappedBy = "giftBox")
    @JoinColumn(name = "order_id")
    private List<Order> orders = new ArrayList<>();

    //==연관관계 메서드==//
    public void setMember(Member member) {
        this.member = member;
        member.setGiftBox(this);
    }

}

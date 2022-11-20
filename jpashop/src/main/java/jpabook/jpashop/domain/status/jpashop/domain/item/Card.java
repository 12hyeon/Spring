package jpabook.orignal_jpashop.domain.status.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B")
@Getter @Setter
public class Card extends Item {

    private String place; // 사용 가능 장소
    private String realPrice;
}
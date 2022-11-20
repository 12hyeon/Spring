package jpabook.orignal_jpashop.domain.status.jpashop.web;

import lombok.Getter;
import lombok.Setter;
@Getter @Setter

public class CardForm {
    private Long id;
    private String name;
    private int price;
    private int stockQuantity;
    private String place; // 사용 가능 장소
    private String realPrice;
}
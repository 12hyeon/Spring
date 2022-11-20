package jpabook.orignal_jpashop.domain.status.jpashop.web;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class MemberForm {
    @NotEmpty(message = "회원 이름은 필수 입니다")
    private String email;
    private String street;
    private String detail;
    private String zipcode;
}
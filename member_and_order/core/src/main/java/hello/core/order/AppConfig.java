package hello.core.order;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;

public class AppConfig {
    public MemberService memberService() { // 구현 객체가 생성
        return new MemberServiceImpl(new MemoryMemberRepository());
        // MemoryMemberRepository() : 역할에 해당하는 배우 선택
    }
    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}

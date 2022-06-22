package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;

public class AppConfig { // 리펙토리 : 메소드 이름에서 역할이 모두 보임
    // 중복된 객체 생성 모음
    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public MemberService memberService() { // 구현 객체 선택
        return new MemberServiceImpl(memberRepository());
        // MemoryMemberRepository() : 역할에 해당하는 배우 선택
    }

    public OrderService orderService() { // 구현 객체 선택
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}

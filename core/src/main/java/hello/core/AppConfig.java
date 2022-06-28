package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig { // 리펙토리 : 메소드 이름에서 역할이 모두 보임

    // spring이 싱글톤을 보장해서 아래 3개 함수가 실행되어도 각 객체마다 1개씩 생성


    @Bean
    public MemberService memberService() { // 구현 객체 선택
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    // 중복된 객체 생성 모음
    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }


    @Bean
    public OrderService orderService() { // 구현 객체 선택
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
        // fix -> rate 배우 교체시 변경하는 부분
    }
}

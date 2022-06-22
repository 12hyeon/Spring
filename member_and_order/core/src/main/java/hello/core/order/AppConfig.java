package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig { // 리펙토리 : 메소드 이름에서 역할이 모두 보임
    // 중복된 객체 생성 모음
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public MemberService memberService() { // 구현 객체 선택
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() { // 구현 객체 선택
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
        // fix -> rate 배우 교체시 변경하는 부분
    }
}

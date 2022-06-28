package hello.core.order;

import hello.core.AppConfig;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach // 테스트 전에 무조건 실행
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }
    // 생성자 주입전
    //MemberService memberService = new MemberServiceImpl(null);
    //OrderService orderService = new OrderServiceImpl(null);

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(2000);
    }

}

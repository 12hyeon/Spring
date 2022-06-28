package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption() {
        new AnnotationConfigApplicationContext(TestBean.class);
    }
    static class TestBean {

        @Autowired(required = false) // 의존 관계 없으면 호출x
        public void setNoBean1(Member noBean1) {
            System.out.println("noBean1 = "+noBean1);
        }

        @Autowired
        public void setNoBean2(@Nullable Member noBean2) { // null이 넣어져서 호출은 됨
            System.out.println("noBean2 = "+noBean2);
        }

        @Autowired
        public void setNoBean3(Optional<Member> noBean3) { // 값이 없으면 Optional.empty간 넣어 호출
            System.out.println("noBean3 = "+noBean3);
        }
    }
}

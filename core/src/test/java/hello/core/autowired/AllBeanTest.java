package hello.core.autowired;

import hello.core.AutoAppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

public class AllBeanTest {

    @Test
    void findAllBean() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);
    }

    static class DiscountService {
        private final Map<String, DiscountService> policyMap;
        private final List<DiscountService> policies;

        public DiscountService(Map<String, DiscountService> policyMap, List<DiscountService> policies) {
            this.policyMap = policyMap;
            this.policies = policies;
            System.out.println("policyMap = " + policyMap);
            System.out.println("policies = "+ policies);
        }
    }
}

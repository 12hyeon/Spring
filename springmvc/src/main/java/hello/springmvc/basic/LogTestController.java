package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @Controller // 반환되는 것이 String이면 view 이름으로 인식 -> 뷰 resolver 찾는 과정(view 찾고 랜더링)
//@Slf4j // Lombok 제공
@RestController // -> 반환 값을 HTTP 메시지 바디에 바로 입력
public class LogTestController {

    private final Logger log = LoggerFactory.getLogger(getClass()); // 인자에는 클래스 정보 넣기
    // @Slf4j에서 자동화

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        // System.out.println("name = " + name);

        // log 레벨을 찍을 수 있음 : 에러가 발생할때 보는 것, os에서 봐야할 정보 등
        log.trace("trace log=", name); // ""+name : 출력이 안되는 경우도 연산이 발생함
        log.debug("debug log={}", name);
        log.info("info log={}", name);
        log.warn("warn log={}", name);
        log.error("error log={}", name);
        // log.info(" into log={}", name); // 많은 정보 출력

        return "ok";
    }
}

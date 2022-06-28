package hello.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value= "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
// ObjectProvider 사용없이 오류 해결 : 가짜 프록시를 집어넣음
public class MyLogger { // 로그 출력 위한 클래스

    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message) {
        System.out.println('[' + uuid + "] [" + requestURL + "]" + message);
    }

    @PostConstruct
    public void init() {
        String uuid = UUID.randomUUID().toString(); // 랜덤 -> 다른 http 요청과 구분
        System.out.println('[' + uuid + "] request scope bean create:" + this);
    }

    @PreDestroy
    public void close() {
        System.out.println('[' + uuid + "] request scope bean close" + this);
    }
}

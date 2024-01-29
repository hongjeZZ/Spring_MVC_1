package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController // String 을 반환 시, resource 를 조회하지 않고 문자열 그대로 메세지 바디에 출력
public class LogTestController {

    // private final Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("/log-test")
    public String logTest() {
        String name = "Spring";

//        log.trace("trace log=" + name);
//        trace 로그를 사용하지 않아도, 컴파일러가 자동으로 문자열 연산, 및 저장함으로 CPU 및 메모리 낭비

        log.trace("trace log={}", name);
        log.debug("debug log={}", name);
        log.info("info log={}", name);
        log.warn("warn log={}", name);
        log.error("error log={}", name);

        return "ok";
    }
}

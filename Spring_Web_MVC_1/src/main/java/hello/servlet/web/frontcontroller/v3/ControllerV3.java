package hello.servlet.web.frontcontroller.v3;

import java.util.Map;

public interface ControllerV3 {

    ModelView process(Map<String, String> paraMap);
}

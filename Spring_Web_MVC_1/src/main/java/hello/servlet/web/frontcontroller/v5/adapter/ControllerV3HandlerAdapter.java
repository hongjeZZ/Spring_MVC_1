package hello.servlet.web.frontcontroller.v5.adapter;

import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v3.ModelView;
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV3HandlerAdapter implements MyHandlerAdapter {
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof ControllerV3);
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        ControllerV3 controller = (ControllerV3) handler;

        Map<String, String> paraMap = createParaMap(request);
        ModelView mv = controller.process(paraMap);

        return mv;
    }

    private Map<String, String> createParaMap(HttpServletRequest request) {
        Map<String, String> paraMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paraName -> paraMap.put(paraName, request.getParameter(paraName)));
        return paraMap;
    }
}

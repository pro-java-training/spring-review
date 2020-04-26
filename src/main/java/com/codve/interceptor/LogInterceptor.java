package com.codve.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.format.DateTimeFormatter;

/**
 * @author admin
 * @date 2020/4/26 14:10
 */
@Slf4j
public class LogInterceptor implements HandlerInterceptor {

    private ThreadLocal<Long> start = ThreadLocal.withInitial(System::currentTimeMillis);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.error("start intercept");
        start.set(System.currentTimeMillis());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long result = System.currentTimeMillis() - start.get();
        log.error("finish intercept, cost " + result + " ms");
        start.remove();
    }
}

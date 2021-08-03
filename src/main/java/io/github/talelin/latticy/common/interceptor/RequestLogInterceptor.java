package io.github.talelin.latticy.common.interceptor;

import io.github.talelin.latticy.common.util.LocalParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Map;

/**
 * @author pedro@TaleLin
 */
@Slf4j
public class RequestLogInterceptor extends HandlerInterceptorAdapter {


    private ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        startTime.set(System.currentTimeMillis());
        System.out.println();
        String str =  request.getQueryString();
        return super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
        // GET 请求的打印日志的方式
        if(request.getMethod().equals("GET") || request.getMethod().equals("DELETE")) {
            System.out.println("getQueryString：");
            System.out.println(request.getQueryString());
            if(request.getQueryString() != null) {
                log.info("[{}] -> [{}] params: [{}] from: {} costs: {}ms",
                        request.getMethod(),
                        request.getServletPath(),
                        URLDecoder.decode(request.getQueryString(),"utf-8"),
                        request.getRemoteAddr(),
                        System.currentTimeMillis() - startTime.get()
                );
            }
            log.info("[{}] -> [{}] from: {} costs: {}ms",
                    request.getMethod(),
                    request.getServletPath(),
                    request.getRemoteAddr(),
                    System.currentTimeMillis() - startTime.get()
            );
        }if(request.getMethod().equals("POST") || request.getMethod().equals("PUT")) {
            log.info("[{}] -> [{}] params: [{}] from: {} costs: {}ms",
                    request.getMethod(),
                    request.getServletPath(),
                    LocalParams.getParams(),
                    request.getRemoteAddr(),
                    System.currentTimeMillis() - startTime.get()
            );
        }
        LocalParams.removeParams();
    }
}

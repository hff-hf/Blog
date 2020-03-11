package com.hff.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @auther hff
 * @time 2020/3/2 - 16:33
 **/
public class MyHandlerItercept implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        String string = request.getRequestURL().toString();

        String[] strings = string.split("/");

        if (strings.length > 3) {

            if ("view".equals(strings[3])) {
                return true;
            }

            if ("admin".equals(strings[3])) {
                if (request.getSession().getAttribute("admin") == null) {
                    response.sendRedirect("/admin");
                    return false;
                } else {
                    return true;
                }
            }
            logger.info(request.getRequestURI() + request.getRequestURL());
            if (strings.length > 4) {

                if ("input".equals(strings[4])) {
                    if (request.getSession().getAttribute("user") == null) {
                        response.sendRedirect("/view/enroll");
                        return false;
                    } else {
                        return true;
                    }
                }

            }

        }

        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

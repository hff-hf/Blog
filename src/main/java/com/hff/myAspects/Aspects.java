package com.hff.myAspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @auther hff
 * @time 2020/3/2 - 11:11
 * 切面 用于获取访问者信息和返回访问者信息
 *
 **/
@Aspect
public class Aspects {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.hff.myController.*.*(..))")
    public void log(){}


    @Before("log()")
    public void before(JoinPoint joinPoint){

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String url = request.getRequestURL().toString();
        String addr = request.getRemoteAddr();
        String mothed = joinPoint.getSignature().getDeclaringTypeName() + "-->" + joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        Infor infor = new Infor(url,addr,mothed,args);

        logger.info("Request : {}",infor);


    }


    @AfterReturning(returning = "result" ,pointcut = "log()")
    public void afterReturn(Object result){

        logger.info("Result : {}" , result);
    }


    private class Infor{

        private String url;
        private String addr;
        private String mothed;
        private  Object[] args;

        public Infor(String url, String addr, String mothed, Object[] args) {
            this.url = url;
            this.addr = addr;
            this.mothed = mothed;
            this.args = args;
        }

        @Override
        public String toString() {
            return "访问信息{" +
                    "url='" + url + '\'' +
                    ", addr='" + addr + '\'' +
                    ", mothed='" + mothed + '\'' +
                    ", args=" + Arrays.toString(args) +
                    '}';
        }
    }

}

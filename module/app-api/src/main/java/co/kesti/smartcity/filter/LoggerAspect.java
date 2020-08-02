package co.kesti.smartcity.filter;

import co.kesti.smartcity.util.JsonUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Component
@Aspect
@Slf4j
public class LoggerAspect {
    @Pointcut("execution(* co.kesti.smartcity.controller.*Controller.*(..))")
    public void loggerPointCut() {
    }

    @Around("loggerPointCut()")
    public Object methodLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        try {
            Object result = proceedingJoinPoint.proceed();
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();


            log.info("[REQ] {} {} {}", request.getMethod(), request.getRequestURI(), JsonUtils.toPrettyString(request.getParameterMap())); // param에 담긴 정보들을 한번에 로깅한다.

            return result;

        } catch (Throwable t) {
            throw t;
        }
    }

}
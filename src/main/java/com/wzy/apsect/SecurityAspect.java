package com.wzy.apsect;

/*
**  登录检查的切面
 */

import com.wzy.annotation.IgnoreSecurity;
import com.wzy.exception.TokenException;
import com.wzy.token.TokenManager;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

import static com.wzy.controller.UserController.DEFAULT_TOKEN_NAME;

@Aspect
@Component
public class SecurityAspect {

    @Autowired
    private TokenManager tokenManager;

    private static final Logger log = Logger.getLogger(SecurityAspect.class);

    @Around("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public Object execute(ProceedingJoinPoint pjp) throws Throwable{
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        log.debug("methodSignature : " + methodSignature);
        Method method = methodSignature.getMethod();

        if (method.isAnnotationPresent(IgnoreSecurity.class)) {
            return pjp.proceed();
        }
        HttpServletRequest request = (HttpServletRequest)(RequestContextHolder.getRequestAttributes());
        String token =request.getHeader(DEFAULT_TOKEN_NAME);

        if(!tokenManager.checkToken(token)){
            String message = String.format("token [%s] is invalid", token);
            log.debug("message : " + message);
            throw new TokenException(message);
        }
        return pjp.proceed();
    }
}
























package com.github.parmenidev.mise.bom.web.annotation.aspect;

import com.github.parmenidev.mise.bom.web.annotation.HeaderAutoForward;
import com.github.parmenidev.mise.bom.web.interceptor.FeignInterceptor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HeaderAutoForwardAspect {

    private FeignInterceptor feignInterceptor;

    public HeaderAutoForwardAspect(FeignInterceptor feignInterceptor) {
        this.feignInterceptor = feignInterceptor;
    }

    @Before("@annotation(headerAutoForward)")
    public void forward(HeaderAutoForward headerAutoForward) {
        feignInterceptor.setHeadersToForward(headerAutoForward.headers());
    }
}

package io.github.parmenidev.mise.bom.security.annotation.aspect;

import io.github.parmenidev.mise.bom.security.exception.UnauthorizedException;
import io.github.parmenidev.mise.bom.web.constant.RequestHeader;
import io.github.parmenidev.mise.bom.web.context.RequestContext;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Aspect
@Component
@ComponentScan(basePackages = "com.github.parmenidev.mise.bom.web.configuration")
public class CheckPermissionAspect {

    private final RequestContext requestContext;
    @Value("${auth.manager.baseUrl}")
    private String authManagerBaseUrl;
    @Value("${auth.manager.checkPermissionPath}")
    private String checkPermissionPath;


    public CheckPermissionAspect(RequestContext requestContext) {
        this.requestContext = requestContext;
    }

    @Before("@annotation(io.github.parmenidev.mise.bom.security.annotation.CheckPermission)")
    public void authenticate() {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.put(RequestHeader.Authorization.getName(), List.of(Optional.ofNullable(requestContext.getAuthorization()).orElse("")));
        try {
             restTemplate.exchange(authManagerBaseUrl + checkPermissionPath, HttpMethod.GET, new HttpEntity<>(httpHeaders), Boolean.class);
         }catch (HttpClientErrorException.Forbidden e){
            throw new UnauthorizedException(HttpStatus.FORBIDDEN.value());
        }
    }




}

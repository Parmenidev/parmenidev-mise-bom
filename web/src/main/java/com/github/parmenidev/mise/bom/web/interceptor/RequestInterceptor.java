package com.github.parmenidev.mise.bom.web.interceptor;

import com.github.parmenidev.mise.bom.web.constant.RequestHeader;
import com.github.parmenidev.mise.bom.web.context.RequestContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Component
public class RequestInterceptor implements HandlerInterceptor {

    private RequestContext requestContext;

    public RequestInterceptor(RequestContext requestContext) {
        this.requestContext = requestContext;
    }

    @Override
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler) {
        populateRequestContext(request);
        return true;
    }

    private void populateRequestContext(final HttpServletRequest request){
        requestContext.setAuthorization(request.getHeader(RequestHeader.Authorization.getName()));
        requestContext.setLang(request.getHeader(RequestHeader.LANG.getName()));
        requestContext.setUserId(request.getHeader(RequestHeader.USER_ID.getName()));
        requestContext.setHttpHeaders(getHeaderMap(request));
    }

    private Map<String, String> getHeaderMap(final HttpServletRequest request){

        HashMap<String, String> headerMap = new HashMap<>();
        Enumeration<String> headerNames = request.getHeaderNames();

        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            headerMap.put(headerName, headerValue);
        }
        return headerMap;
    }
}

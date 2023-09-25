package io.github.parmenidev.mise.bom.web.interceptor;

import io.github.parmenidev.mise.bom.web.context.RequestContext;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public class FeignInterceptor implements RequestInterceptor {

    private String[] headersToForward;
    private RequestContext requestContext;

    public FeignInterceptor(RequestContext requestContext) {
        this.requestContext = requestContext;
    }

    @Override
    public void apply(RequestTemplate requestTemplate) {
        if (headersToForward != null && headersToForward.length != 0) {
            for (String header : headersToForward) {
                if (!ObjectUtils.isEmpty(header)) {
                    String value = requestContext.getHttpHeaders().get(header.toLowerCase());
                    if (!ObjectUtils.isEmpty(value)) {
                        requestTemplate.header(header, value);
                    }
                }
            }
        }
    }


    public void setHeadersToForward(String[] headersToForward) {
        this.headersToForward = headersToForward;
    }
}
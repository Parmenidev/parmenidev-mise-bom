package io.github.parmenidev.mise.bom.web.configuration;

import io.github.parmenidev.mise.bom.web.interceptor.RequestInterceptor;
import io.github.parmenidev.mise.bom.web.context.RequestContext;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@ComponentScan
@Configuration
@AutoConfiguration
public class WebAutoConfiguration implements WebMvcConfigurer {

    private final RequestInterceptor requestHeaderInterceptor;

    public WebAutoConfiguration(RequestInterceptor requestHeaderInterceptor) {
        this.requestHeaderInterceptor = requestHeaderInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestHeaderInterceptor);
    }

    @Bean
    @RequestScope
    public RequestContext requestContext() {
        return new RequestContext();
    }
}

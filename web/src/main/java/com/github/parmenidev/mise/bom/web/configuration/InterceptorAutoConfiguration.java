package com.github.parmenidev.mise.bom.web.configuration;

import com.github.parmenidev.mise.bom.web.interceptor.FeignInterceptor;
import com.github.parmenidev.mise.bom.web.interceptor.RequestInterceptor;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@AutoConfiguration
@Import({RequestInterceptor.class, FeignInterceptor.class})
public class InterceptorAutoConfiguration {

}

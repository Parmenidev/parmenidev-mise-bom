package io.github.parmenidev.mise.bom.web.configuration;

import io.github.parmenidev.mise.bom.web.interceptor.FeignInterceptor;
import io.github.parmenidev.mise.bom.web.interceptor.RequestInterceptor;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@ComponentScan
@Configuration
@AutoConfiguration
@Import({RequestInterceptor.class, FeignInterceptor.class})
public class InterceptorAutoConfiguration {

}

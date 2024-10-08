package io.github.parmenidev.mise.bom.security;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@ComponentScan
@Configuration
@EnableAspectJAutoProxy
@EnableAutoConfiguration
public class GlobalConfiguration {

}

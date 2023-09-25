package io.github.parmenidev.mise.bom.web.configuration;

import io.github.parmenidev.mise.bom.async.configuration.ExecutorAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
@AutoConfiguration
@ImportAutoConfiguration({org.springframework.cloud.openfeign.FeignAutoConfiguration.class, ExecutorAutoConfiguration.class})
public class FeignAutoConfiguration {
}

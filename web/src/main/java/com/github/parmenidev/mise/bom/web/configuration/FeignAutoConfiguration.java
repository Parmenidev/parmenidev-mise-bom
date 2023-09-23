package com.github.parmenidev.mise.bom.web.configuration;

import com.github.parmenidev.mise.bom.async.configuration.ExecutorAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfiguration
@ImportAutoConfiguration({org.springframework.cloud.openfeign.FeignAutoConfiguration.class, ExecutorAutoConfiguration.class})
public class FeignAutoConfiguration {
}

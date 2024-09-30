package io.github.parmenidev.mise.bom.async.configuration;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@Configuration
@AutoConfiguration
@Import({ExecutorConfiguration.class})
public class ExecutorAutoConfiguration {

}

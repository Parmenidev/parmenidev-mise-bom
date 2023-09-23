package io.github.parmenidev.mise.bom.async.configuration;

import io.github.parmenidev.mise.bom.async.context.RequestContextThreadPoolTaskExecutor;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;

import java.util.concurrent.Executor;

@Configuration
@AutoConfiguration
public class ExecutorAutoConfiguration implements AsyncConfigurer {
    @Override
    @Bean
    public Executor getAsyncExecutor() {
        return new RequestContextThreadPoolTaskExecutor();
    }
}

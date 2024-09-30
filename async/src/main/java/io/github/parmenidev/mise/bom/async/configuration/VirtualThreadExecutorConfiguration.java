package io.github.parmenidev.mise.bom.async.configuration;

import io.github.parmenidev.mise.bom.async.context.RequestContextVirtualThreadTaskExecutor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;

import java.util.concurrent.Executor;

@Configuration
public class VirtualThreadExecutorConfiguration implements AsyncConfigurer {


    @Bean
    @Override
    public Executor getAsyncExecutor() {
        return new RequestContextVirtualThreadTaskExecutor();
    }
}

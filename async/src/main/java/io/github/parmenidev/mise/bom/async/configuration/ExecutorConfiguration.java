package io.github.parmenidev.mise.bom.async.configuration;

import io.github.parmenidev.mise.bom.async.context.RequestContextThreadPoolTaskExecutor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;

import java.util.concurrent.Executor;

@Setter
@Configuration
@ConditionalOnMissingBean(VirtualThreadExecutorConfiguration.class)
public class ExecutorConfiguration implements AsyncConfigurer {

    @Override
    @Bean
    public Executor getAsyncExecutor() {
        return new RequestContextThreadPoolTaskExecutor();
    }

}

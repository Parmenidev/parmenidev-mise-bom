package com.github.parmenidev.mise.bom.async.context;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class RequestContextThreadPoolTaskExecutor extends ThreadPoolTaskExecutor {

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        return super.submit(new AsyncRequestContextPropagator<>(task, RequestContextHolder.currentRequestAttributes()));
    }
}

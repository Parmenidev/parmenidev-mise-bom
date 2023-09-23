package com.github.parmenidev.mise.bom.async.context;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.concurrent.Callable;

public class AsyncRequestContextPropagator<T> implements Callable<T> {
    private Callable<T> task;
    private RequestAttributes context;

    public AsyncRequestContextPropagator(Callable<T> task, RequestAttributes context) {
        this.task = task;
        this.context = context;
    }

    @Override
    public T call() throws Exception {
        if (context != null) {
            RequestContextHolder.setRequestAttributes(context);
        }

        try {
            return task.call();
        } finally {
            RequestContextHolder.resetRequestAttributes();
        }
    }
}

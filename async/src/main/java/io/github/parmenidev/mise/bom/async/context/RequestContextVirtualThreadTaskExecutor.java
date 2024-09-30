package io.github.parmenidev.mise.bom.async.context;

import org.springframework.core.task.VirtualThreadTaskExecutor;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;

public class RequestContextVirtualThreadTaskExecutor extends VirtualThreadTaskExecutor {

    @Override
    public <T> CompletableFuture<T> submitCompletable(Callable<T> task) {
        return super.submitCompletable(new AsyncRequestContextPropagator<>(task, RequestContextHolder.getRequestAttributes()));

    }
}

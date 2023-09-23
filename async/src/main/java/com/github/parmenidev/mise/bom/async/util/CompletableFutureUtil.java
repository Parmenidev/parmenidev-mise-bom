package com.github.parmenidev.mise.bom.async.util;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureUtil {

    public static <T> List<T> launchFutures(final List<CompletableFuture<T>> futures) {
        return futures.stream()
                .map(CompletableFutureUtil::launchFuture)
                .toList();
    }

    public static <T> T launchFuture(final CompletableFuture<T> completeFuture) {
        try {
            return completeFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException();
        }
    }
}

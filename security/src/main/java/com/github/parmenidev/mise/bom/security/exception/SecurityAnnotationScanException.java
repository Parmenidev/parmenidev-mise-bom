package com.github.parmenidev.mise.bom.security.exception;

public class SecurityAnnotationScanException extends RuntimeException {

    private String message;

    public SecurityAnnotationScanException(String message) {
        super(message);
    }
}

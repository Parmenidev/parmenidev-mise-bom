package io.github.parmenidev.mise.bom.security.exception;

public class UnauthorizedException extends RuntimeException{

    private static final String FORBIDDEN_RESOURCE = "Forbidden resource";
    private int statusCode;

    public UnauthorizedException(int statusCode) {
        super(FORBIDDEN_RESOURCE);
        this.statusCode = statusCode;
    }
}

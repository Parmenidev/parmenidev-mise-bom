package io.github.parmenidev.mise.bom.error.exception;

import io.github.parmenidev.mise.bom.error.exception.enums.PredefinedError;
import org.springframework.http.HttpStatus;

public class UnauthorizedException extends BaseException {

    public UnauthorizedException() {
        super(HttpStatus.UNAUTHORIZED, PredefinedError.UNAUTHORIZED.getMessage(), null, null);
    }

    public UnauthorizedException(Throwable cause) {
        super(HttpStatus.UNAUTHORIZED, PredefinedError.UNAUTHORIZED.getMessage(), null, cause);
    }
}

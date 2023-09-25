package io.github.parmenidev.mise.bom.error.exception;

import io.github.parmenidev.mise.bom.error.exception.enums.PredefinedError;
import org.springframework.http.HttpStatus;

public class ForbiddenException extends BaseException {

    public ForbiddenException() {
        super(HttpStatus.FORBIDDEN, PredefinedError.FORBIDDEN_RESOURCE.getMessage(), null, null);
    }

    public ForbiddenException(Throwable cause) {
        super(HttpStatus.FORBIDDEN, PredefinedError.FORBIDDEN_RESOURCE.getMessage(), null, cause);
    }
}

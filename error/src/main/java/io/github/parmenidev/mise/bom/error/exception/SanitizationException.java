package io.github.parmenidev.mise.bom.error.exception;

import io.github.parmenidev.mise.bom.error.exception.enums.PredefinedError;
import org.springframework.http.HttpStatus;

public class SanitizationException extends BaseException {


    public SanitizationException(String msg) {
        super(HttpStatus.BAD_REQUEST, PredefinedError.INVALID_PARAMETER.getMessage(), null, null);
    }

    public SanitizationException(String msg, Throwable cause) {
        super(HttpStatus.BAD_REQUEST, PredefinedError.INVALID_PARAMETER.getMessage(), null, cause);
    }
}

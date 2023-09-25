package io.github.parmenidev.mise.bom.error.exception;

import io.github.parmenidev.mise.bom.error.exception.enums.PredefinedError;
import org.springframework.http.HttpStatus;

public class RestExecutionException extends BaseException {

    public RestExecutionException(HttpStatus httpStatus, String msg, String detail, Throwable cause) {
        super(httpStatus, msg, detail, cause);
    }

    public RestExecutionException(HttpStatus httpStatus, String detail, Throwable cause) {
        super(httpStatus, PredefinedError.GENERIC_ERROR.getMessage(), detail, cause);
    }

    public RestExecutionException(String msg, String detail, Throwable cause) {
        this(HttpStatus.INTERNAL_SERVER_ERROR, msg, detail, cause);
    }

    public RestExecutionException(String detail, Throwable cause) {
        this(HttpStatus.INTERNAL_SERVER_ERROR, PredefinedError.GENERIC_ERROR.getMessage(), detail, cause);
    }

    public RestExecutionException(Throwable cause) {
        this(HttpStatus.INTERNAL_SERVER_ERROR, PredefinedError.GENERIC_ERROR.getMessage(), null, cause);
    }
}

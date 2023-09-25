package io.github.parmenidev.mise.bom.error.exception;

import lombok.Getter;
import io.github.parmenidev.mise.bom.error.model.ErrorResponse;
import org.springframework.core.NestedRuntimeException;
import org.springframework.http.HttpStatus;

@Getter
public abstract class BaseException extends NestedRuntimeException {

    private HttpStatus httpStatus;
    private String detail;

    public BaseException(HttpStatus httpStatus, String msg, String detail, Throwable cause) {
        super(msg, cause);
        this.httpStatus = httpStatus;
        this.detail = detail;
    }

    public ErrorResponse toErrorResponse(){
        return ErrorResponse.builder().message(this.getMessage()).build();
    }
}

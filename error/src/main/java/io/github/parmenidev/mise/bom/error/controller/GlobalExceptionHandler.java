package io.github.parmenidev.mise.bom.error.controller;

import io.github.parmenidev.mise.bom.error.exception.BaseException;
import io.github.parmenidev.mise.bom.error.exception.enums.PredefinedError;
import io.github.parmenidev.mise.bom.error.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorResponse> handle(BaseException e) {
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(e.toErrorResponse(), e.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handle(Exception e) {
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(ErrorResponse.builder().message(PredefinedError.GENERIC_ERROR.getMessage()).build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

package io.github.parmenidev.mise.bom.error.configuration;

import io.github.parmenidev.mise.bom.error.controller.GlobalExceptionHandler;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@AutoConfiguration
@Import(GlobalExceptionHandler.class)
public class ErrorAutoConfiguration {
}

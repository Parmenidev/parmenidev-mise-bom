package io.github.parmenidev.mise.bom.error.exception.enums;

public enum PredefinedError{

    GENERIC_ERROR("Error occurs during request processing"),
    FORBIDDEN_RESOURCE("Forbidden resource. You don't have permissions to access to this resource"),

    UNAUTHORIZED("Unauthorized access"),
    INVALID_PARAMETER("A parameter was invalid");

    private final String message;

    PredefinedError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

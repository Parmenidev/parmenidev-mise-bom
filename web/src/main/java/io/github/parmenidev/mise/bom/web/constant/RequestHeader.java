package io.github.parmenidev.mise.bom.web.constant;

public enum RequestHeader {

    LANG("lang"),
    Authorization("Authorization"),
    USER_ID("user-id");

    private final String name;

    RequestHeader(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
}

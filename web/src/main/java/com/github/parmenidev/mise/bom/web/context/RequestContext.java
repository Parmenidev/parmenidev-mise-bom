package com.github.parmenidev.mise.bom.web.context;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Setter
@Getter
public class RequestContext {
    private String lang;
    private String userId;
    private String authorization;
    private Map<String, String> httpHeaders;
}

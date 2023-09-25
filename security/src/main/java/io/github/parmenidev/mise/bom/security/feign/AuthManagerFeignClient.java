package io.github.parmenidev.mise.bom.security.feign;

import io.github.parmenidev.mise.bom.web.annotation.HeaderAutoForward;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "authManagerFeignClient", url = "${auth.manager.baseUrl}")
public interface AuthManagerFeignClient {

    @HeaderAutoForward(headers = "Authorization")
    @GetMapping(value = "${auth.manager.path}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Boolean> checkPermission();
}

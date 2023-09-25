package io.github.parmenidev.mise.bom.security.annotation.aspect;

import feign.FeignException;
import io.github.parmenidev.mise.bom.error.exception.ForbiddenException;
import io.github.parmenidev.mise.bom.error.exception.RestExecutionException;
import io.github.parmenidev.mise.bom.error.exception.UnauthorizedException;
import io.github.parmenidev.mise.bom.security.feign.AuthManagerFeignClient;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CheckPermissionAspect {

    private final AuthManagerFeignClient authManagerFeignClient;

    public CheckPermissionAspect(AuthManagerFeignClient authManagerFeignClient) {
        this.authManagerFeignClient = authManagerFeignClient;
    }

    @Before("@annotation(io.github.parmenidev.mise.bom.security.annotation.CheckPermission)")
    public void authenticate() {
        try {
            authManagerFeignClient.checkPermission();
        } catch (FeignException.Unauthorized e) {
            throw new UnauthorizedException(e);
        } catch (FeignException.Forbidden e) {
            throw new ForbiddenException(e);
        } catch (FeignException e) {
            throw new RestExecutionException("Error occurs during auth manager invocation", e);
        }
    }
}

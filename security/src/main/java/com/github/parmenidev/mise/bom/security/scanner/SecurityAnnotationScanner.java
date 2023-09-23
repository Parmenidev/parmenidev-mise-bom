package com.github.parmenidev.mise.bom.security.scanner;

import com.github.parmenidev.mise.bom.security.annotation.CheckPermission;
import com.github.parmenidev.mise.bom.security.annotation.PublicAccess;
import com.github.parmenidev.mise.bom.security.exception.SecurityAnnotationScanException;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import java.lang.reflect.Method;

@ComponentScan(basePackages = "${project.package.prefix}", includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = RestController.class)
})
@Slf4j
@Component
public class SecurityAnnotationScanner {

    @Value("${project.package.prefix}")
    private String basePackage;

    @PostConstruct
    public void scanRestControllerMethods() {
        ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
        scanner.addIncludeFilter(new AnnotationTypeFilter(RestController.class));
        scanner.addIncludeFilter(new AnnotationTypeFilter(Controller.class));

        for (BeanDefinition beanDefinition : scanner.findCandidateComponents(basePackage)) {
            try {
                Class<?> clazz = Class.forName(beanDefinition.getBeanClassName());
                Method[] methods = clazz.getDeclaredMethods();
                for (Method method : methods) {
                    if (!method.isAnnotationPresent(CheckPermission.class) && !method.isAnnotationPresent(PublicAccess.class)) {
                        throw new SecurityAnnotationScanException("Security annotation @CheckPermission or @PublicAccess is missing on the method "
                                + method.getName() + " in class " + clazz.getName());
                    } else if (method.isAnnotationPresent(CheckPermission.class) && method.isAnnotationPresent(PublicAccess.class)) {
                        throw new SecurityAnnotationScanException("Both Security annotation @CheckPermission and @PublicAccess present on the same method "
                                + method.getName() + " in class " + clazz.getName());
                    }
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}

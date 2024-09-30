package io.github.parmenidev.mise.bom.async.annotation;

import io.github.parmenidev.mise.bom.async.configuration.VirtualThreadExecutorConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class VirtualThreadsImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        if (importingClassMetadata.hasAnnotation(Configuration.class.getName()) ||
                importingClassMetadata.hasAnnotation(SpringBootApplication.class.getName())) {
            return new String[]{VirtualThreadExecutorConfiguration.class.getName()};
        }
        return new String[0];
    }
}

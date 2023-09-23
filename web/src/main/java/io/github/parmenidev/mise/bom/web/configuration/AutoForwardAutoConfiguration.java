package io.github.parmenidev.mise.bom.web.configuration;

import io.github.parmenidev.mise.bom.web.annotation.aspect.HeaderAutoForwardAspect;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@AutoConfiguration
@Import(HeaderAutoForwardAspect.class)
public class AutoForwardAutoConfiguration {
}

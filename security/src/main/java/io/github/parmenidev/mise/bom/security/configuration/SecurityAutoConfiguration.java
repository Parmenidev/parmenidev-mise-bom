package io.github.parmenidev.mise.bom.security.configuration;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@AutoConfiguration
@Import({SecurityConfiguration.class})
public class SecurityAutoConfiguration {
}

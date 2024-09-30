package io.github.parmenidev.mise.bom.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(final HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(request -> request.requestMatchers(new AntPathRequestMatcher("/actuator/**")).permitAll())
                .authorizeHttpRequests(request -> request.requestMatchers(new AntPathRequestMatcher("/public/**")).permitAll())
                .authorizeHttpRequests(request -> request.requestMatchers(new AntPathRequestMatcher("/secure/**")).permitAll())
                .sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.ALWAYS));
        return http.build();
    }

}

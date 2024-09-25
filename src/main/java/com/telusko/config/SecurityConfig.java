package com.telusko.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authz -> authz
                .requestMatchers("/h2-console/**").permitAll()  // Allow access to H2 console without authentication
                .anyRequest().authenticated()                  // Secure all other endpoints
            )
            .oauth2Login()  // Enable OAuth2 login
            .and()
            .csrf().disable()  // Disable CSRF protection for H2 console access
            .headers().frameOptions().disable();  // Allow H2 console to be displayed

        return http.build();
    }
}

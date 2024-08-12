package com.nisuminternacional.eva.backend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
                .requestMatchers("/api/usuarios/registro").permitAll() // Permitir acceso sin autenticación a este endpoint
                .anyRequest().authenticated() // Requiere autenticación para cualquier otra solicitud
            .and()
            .httpBasic(); // Puedes usar httpBasic para pruebas o JWT en producción

        return http.build();
    }
}


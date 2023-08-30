package com.project.coches.config;


import com.project.coches.security.JwtAuthFilter;
import com.project.coches.security.JwtAuthenticationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Clase para la creacion de Beans a utilizar
 */
@RequiredArgsConstructor
@Configuration
public class ApplicationConfig {

    private final JwtAuthenticationProvider jwtAuthenticationProvider;

    /**
     * Bean de password encoder para inyeccion
     * @return Implementacion BCryptPasswordEncoder
     */

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /**
     * Bean de JwtAuthFilter para inyeccion
     * @return Implementacion JwtAuthFilter
     */
    @Bean
    public JwtAuthFilter jwtAuthFilter(){
        return new JwtAuthFilter(jwtAuthenticationProvider);
    }






}

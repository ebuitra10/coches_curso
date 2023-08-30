package com.project.coches.config;


import com.project.coches.exception.AccessDeniedHandlerException;
import com.project.coches.security.JwtAuthFilter;
import com.project.coches.security.Roles;
import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.management.relation.RoleStatus;
import java.util.Arrays;

/**
 * Clase que configura lo relacionado a las peticiones HTTP
 */
@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {


    private final AccessDeniedHandlerException accessDeniedHandlerException;

    private final JwtAuthFilter jwtAuthFilter;

    /**
     * Configura la seguridad de las peticiones HTTP
     * @param http peticion a configurar
     * @return
     * @throws Exception
     */

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http
                .cors(Customizer.withDefaults())
                .exceptionHandling().accessDeniedHandler(accessDeniedHandlerException)
                .and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(requests ->
                        requests.requestMatchers("/auth/**", "swagger-ui.html", "/swagger-ui/**", "/v3/api-docs/**").permitAll()
                                .requestMatchers(HttpMethod.POST, "/customers").permitAll()
                                /*con solo utilizar el hash Autohority ya puedo acceder a la ruta segun el rol que
                                tenga utilizando solamente autoridades*/
                                .requestMatchers("/cars").hasRole(Roles.CUSTOMER)
                                /*.requestMatchers("/cars").hasAnyAuthority("prueba")*/

                                //Solo toma el primer filtro, ya no se puede anidar un rol con una autoridad
                                //.requestMatchers("/cars").hasRole(Roles.CUSTOMER)

                                //hasAuthority o hashRole para un solo rol/autoridad
                                //hasAnyAuthority para varios roles
                                .anyRequest().authenticated()

                        );

        return http.build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList(CorsConfiguration.ALL));
        configuration.setAllowedMethods(Arrays.asList(CorsConfiguration.ALL));
        configuration.setAllowedHeaders(Arrays.asList(CorsConfiguration.ALL));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
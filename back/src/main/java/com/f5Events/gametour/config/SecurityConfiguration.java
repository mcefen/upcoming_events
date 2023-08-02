/* package com.f5Events.gametour.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

 import com.f5Events.gametour.models.User;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Bean
    CorsConfigurationSource CorsConfigurationSource(){
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowCredentials(true);
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails pablo = User.builder()
        .username("Pablo")
        .password()
        .roles("USER")
        .build();

        UserDetails pablo2 = User.builder()
        .username("Pablo2")
        .password()
        .roles("ADMIN")
        .build();

        Collection<UserDetails> users = new ArrayList<>();
        users.add(pablo);
        users.add(pablo2);

        return new InMemoryUserDetailsManager(users);
    }
} */


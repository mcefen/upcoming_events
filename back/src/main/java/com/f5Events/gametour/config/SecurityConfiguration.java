 package com.f5Events.gametour.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CorsConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.f5Events.gametour.models.User1;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    
       @Bean
       SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
               .cors(withDefaults()) 
                .csrf(csfr -> csfr.disable())
                .formLogin(form -> form.disable())
                .logout(out -> out
                        .logoutUrl("/api/v1/logout")
                        .deleteCookies("JSESSIONID"))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/eventgames/**").permitAll()
                        .requestMatchers("/games/**").permitAll()
                        .requestMatchers("/user/**").permitAll()
                        .anyRequest().authenticated())
                 .httpBasic(withDefaults()) 
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED));

        return http.build();
    }
    
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowCredentials(true);
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserBuilder users = User.builder();
        UserDetails user = users
                .username("Pablo")
                .password("1234")
                .roles("USER")
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password("1234")
                .roles("USER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }
}
  
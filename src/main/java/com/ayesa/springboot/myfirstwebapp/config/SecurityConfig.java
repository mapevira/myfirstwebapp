package com.ayesa.springboot.myfirstwebapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * Created by jt, Spring Framework Guru.
 *
 * @author architecture - rperezv
 * @version 13/11/2024 - 15:16
 * @since jdk 1.17
 */
@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {
        UserDetails userDetails = User.builder()
                .passwordEncoder(passwordEncoder()::encode)
                .username("in28minutes")
                .password("dummy")
                .roles("USER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(userDetails);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

package com.JavaPracticeExample.Security.config;

import com.JavaPracticeExample.Security.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final UserRepository repository;


    @Bean
    public UserDetailsService userDetailsService(){
        return username -> repository.findByEmail(Integer.valueOf(username))
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));
    }
}

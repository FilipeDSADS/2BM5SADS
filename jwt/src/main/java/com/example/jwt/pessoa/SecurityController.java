package com.example.jwt.pessoa;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityController {

    public DefaultSecurityFilterChain securityFilterAutoConfiguration(HttpSecurity httpSecurity) throws Exception{

        httpSecurity.csrf(csrf -> csrf.disable()).build();
        return httpSecurity.build();
    }

    //DESATIVAR O CSRF
}

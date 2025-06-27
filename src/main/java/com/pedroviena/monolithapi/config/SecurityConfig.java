package com.pedroviena.monolithapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Desabilita o CSRF, pois não usaremos sessões/cookies para autenticação
                .csrf(csrf -> csrf.disable())

                // Define a política de gerenciamento de sessão como STATELESS (sem estado)
                // A API não vai guardar informações de sessão do usuário
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                // Configura as regras de autorização para as requisições HTTP
                .authorizeHttpRequests(authorize -> authorize
                        // Permite que TODAS as requisições (anyRequest) sejam acessadas sem autenticação (permitAll)
                        .anyRequest().permitAll() 
                );

        return http.build();
    }
}
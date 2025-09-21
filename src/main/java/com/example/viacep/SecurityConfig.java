package com.example.viacep;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
class SecurityConfig {

  @Bean
  SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
      //.csrf(csrf -> csrf.disable()) // API stateless; reative CSRF se usar cookies/form
      .authorizeHttpRequests(auth -> auth
          // Swagger/OpenAPI (ajuste se usar springdoc)
          .requestMatchers("/swagger-ui.html", "/swagger-ui/**", "/v3/api-docs/**").permitAll()
          // Saúde/actuator (se existir)
          .requestMatchers("/actuator/**").permitAll()
          // Leitura pública
          .requestMatchers(HttpMethod.GET, "/api/addresses/**").permitAll()
          // Demais operações exigem autenticação
          .anyRequest().authenticated()
      )
      .httpBasic(Customizer.withDefaults()); // ou .formLogin(Customizer.withDefaults())
    return http.build();
  }

  @Bean
  UserDetailsService users() {
    var user = User.withUsername("user")
        .password("{noop}password") // apenas para testes; use BCrypt em produção
        .roles("USER")
        .build();
    return new InMemoryUserDetailsManager(user);
  }
}

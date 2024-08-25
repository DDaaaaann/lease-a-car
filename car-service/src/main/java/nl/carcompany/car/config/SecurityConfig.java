package nl.carcompany.car.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(authz -> authz
        .requestMatchers("/cars/**").hasAuthority("SCOPE_cars:read")
        .requestMatchers(HttpMethod.POST, "/cars/**").hasAuthority("SCOPE_cars:write")
        .requestMatchers(HttpMethod.DELETE, "/cars/**").hasAuthority("SCOPE_cars:write")
        .requestMatchers(HttpMethod.PUT, "/cars/**").hasAuthority("SCOPE_cars:write")
        .anyRequest().authenticated()
    );

    http.oauth2ResourceServer(oauth -> oauth.jwt(Customizer.withDefaults()));
    return http.build();
  }
}
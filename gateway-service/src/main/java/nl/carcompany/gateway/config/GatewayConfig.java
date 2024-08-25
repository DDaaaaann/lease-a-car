package nl.carcompany.gateway.config;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class GatewayConfig {

  private final GatewayServiceProperties properties;

  @Bean
  public SecurityWebFilterChain securityWebFilterChain(final ServerHttpSecurity http) {
    http.authorizeExchange(authorizeExchangeSpec -> authorizeExchangeSpec
        .pathMatchers("/carservice/**").hasAuthority("SCOPE_cars")
        .pathMatchers("/customerservice/**").hasAuthority("SCOPE_customers")
        .pathMatchers("/leaseservice/**").hasAuthority("SCOPE_leases")
        .anyExchange().authenticated());

    http.oauth2ResourceServer(oAuth2 -> oAuth2.jwt(Customizer.withDefaults()));
    return http.build();
  }

  @Bean
  public RouteLocator routes(final RouteLocatorBuilder builder) {
    return builder.routes()
        .route("customer-service", r -> r.path(properties.getCustomerService().getContext() + "/**")
            .uri(properties.getCustomerService().getUrl()))
        .route("car-service", r -> r.path(properties.getCarService().getContext() + "/**")
            .uri(properties.getCarService().getUrl()))
        .route("lease-service", r -> r.path(properties.getLeaseService().getContext() + "/**")
            .uri(properties.getLeaseService().getUrl()))
        .build();
  }
}
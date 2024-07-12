package nl.carcompany.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

  @Bean
  public RouteLocator routes(RouteLocatorBuilder builder) {
    return builder.routes()
        .route("customer-service", r -> r.path("/customers/**")
            .uri("http://localhost:8081/customers"))
        .route("car-service", r -> r.path("/cars/**")
            .uri("http://localhost:8082/cars"))
        .route("lease-service", r -> r.path("/leases/**")
            .uri("http://localhost:8083/leases"))
        .build();
  }
}
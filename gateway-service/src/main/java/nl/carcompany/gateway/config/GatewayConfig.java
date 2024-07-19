package nl.carcompany.gateway.config;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class GatewayConfig {

  private final GatewayServiceProperties properties;

  @Bean
  public RouteLocator routes(RouteLocatorBuilder builder) {
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
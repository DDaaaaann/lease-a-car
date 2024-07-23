package nl.carcompany.lease.config;

import lombok.RequiredArgsConstructor;
import nl.carcompany.rest.lease.ApiClient;
import nl.carcompany.rest.lease.api.CarClient;
import nl.carcompany.rest.lease.api.CustomerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class LeaseConfig {

  private final LeaseServiceProperties properties;

  @Bean
  public CarClient carClient() {
    return new CarClient(new ApiClient()
        .setBasePath(properties.getGatewayService().getUrl()));
  }

  @Bean
  public CustomerClient customerClient() {
    return new CustomerClient(new ApiClient()
        .setBasePath(properties.getGatewayService().getUrl()));
  }

}

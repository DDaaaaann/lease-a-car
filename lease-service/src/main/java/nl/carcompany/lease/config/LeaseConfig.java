package nl.carcompany.lease.config;

import nl.carcompany.rest.lease.api.CarClient;
import nl.carcompany.rest.lease.api.CustomerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LeaseConfig {

  @Bean
  public CarClient carClient() {
    return new CarClient();
  }

  @Bean
  public CustomerClient customerClient() {
    return new CustomerClient();
  }

}

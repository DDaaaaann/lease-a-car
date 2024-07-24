package nl.carcompany.gateway.config;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "gateway")
public class GatewayServiceProperties {

  private Service carService;
  private Service customerService;
  private Service leaseService;

  @Getter
  @Setter
  @Validated
  public static class Service {

    @NotBlank
    private String name;

    private String context;

    protected String getUrl() {
      return "lb://" + getName();
    }
  }
}
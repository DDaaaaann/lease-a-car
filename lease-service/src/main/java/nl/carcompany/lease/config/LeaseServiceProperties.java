package nl.carcompany.lease.config;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "lease")
public class LeaseServiceProperties {

  private Service gatewayService;

  //  TODO Make shared
  @Getter
  @Setter
  @Validated
  public static class Service {

    @NotBlank
    private String url;

    private String context;
  }
}
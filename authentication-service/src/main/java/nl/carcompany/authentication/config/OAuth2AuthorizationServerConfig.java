package nl.carcompany.authentication.config;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import java.text.ParseException;
import java.util.Collections;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.oauth2.server.authorization.client.InMemoryRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configuration.OAuth2AuthorizationServerConfiguration;

@Configuration
@Import(OAuth2AuthorizationServerConfiguration.class)
public class OAuth2AuthorizationServerConfig {

  @Bean
  public RegisteredClientRepository registeredClientRepository() {
    List<RegisteredClient> registrations = Collections.emptyList();
    return new InMemoryRegisteredClientRepository(registrations);
  }

  @Bean
  public JWKSource<SecurityContext> jwkSource() throws ParseException {
    RSAKey rsaKey = RSAKey.parse("asd");
    JWKSet jwkSet = new JWKSet(rsaKey);
    return (jwkSelector, securityContext) -> jwkSelector.select(jwkSet);
  }
}

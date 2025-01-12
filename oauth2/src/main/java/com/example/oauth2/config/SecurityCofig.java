package com.example.oauth2.config;


import java.security.KeyPair;
import java.security.KeyPairGenerator;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.access.method.P;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.OidcScopes;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationConsent;
import org.springframework.security.oauth2.server.authorization.client.InMemoryRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configuration.OAuth2AuthorizationServerConfiguration;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configurers.OAuth2AuthorizationServerConfigurer;
import org.springframework.security.oauth2.server.authorization.settings.AuthorizationServerSettings;
import org.springframework.security.oauth2.server.authorization.settings.ConfigurationSettingNames.AuthorizationServer;
import org.springframework.security.oauth2.server.authorization.token.JwtEncodingContext;
import org.springframework.security.oauth2.server.authorization.token.OAuth2TokenCustomizer;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;

@Configuration
public class SecurityCofig {

    @Bean
    @Order(1)
    SecurityFilterChain authorisationSecurityFilterChain(HttpSecurity http) throws Exception{
        OAuth2AuthorizationServerConfiguration.applyDefaultSecurity(http);
        http.getConfigurer(OAuth2AuthorizationServerConfigurer.class)
            .oidc(Customizer.withDefaults());

        http.exceptionHandling(
            e->e.authenticationEntryPoint(
                new LoginUrlAuthenticationEntryPoint("/login")
            )
        ); 

        return http.build();
    }

    @Bean
    @Order(2)
    SecurityFilterChain appSecurityFilterChain(HttpSecurity http) throws Exception{
        
        http.formLogin()
            .and()
            .authorizeHttpRequests()
            .requestMatchers("/oauth2/jwks").permitAll()
            .anyRequest()
            .authenticated();
        return http.build();
    }

    @Bean
    UserDetailsService userDetailsService(){
        System.out.println("USER DETAILS SERVICE CREATED");
        var u1 = User.withUsername("akshay")
                     .password("111")
                     .authorities("read")
                     .build();




      var uds =  new InMemoryUserDetailsManager();
      uds.createUser(u1);
      return uds;

  }

  @Bean
  PasswordEncoder passwordEncoder(){
    return NoOpPasswordEncoder.getInstance();
  }


  @Bean
  RegisteredClientRepository registeredClientRepository(){
    RegisteredClient r1 = RegisteredClient.withId(UUID.randomUUID().toString())
                                          .clientId("client")
                                          .clientSecret("secret")
                                          .scope(OidcScopes.OPENID)
                                          .redirectUri("https://hianime.to")
                                          .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                                          .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                                          .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
                                          .build();
    return new InMemoryRegisteredClientRepository(r1);
  }

  @Bean 
  AuthorizationServerSettings authorizationServerSettings(){
    return AuthorizationServerSettings.builder().build();
  }

  @Bean
  JWKSource<SecurityContext> jwkSource() throws Exception {
  KeyPairGenerator kg = KeyPairGenerator.getInstance("RSA");
  kg.initialize(2048);
  KeyPair kp = kg.generateKeyPair();

  RSAPublicKey publicKey = (RSAPublicKey) kp.getPublic();
  RSAPrivateKey privateKey = (RSAPrivateKey) kp.getPrivate();

  RSAKey key = new RSAKey.Builder(publicKey)
  .privateKey(privateKey)
  .keyID(UUID.randomUUID().toString())
  .build();

  JWKSet set = new JWKSet(key);
  return new ImmutableJWKSet(set);

  }

  

}

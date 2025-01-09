package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    //Use application property and inject the value instead using @value 
    private String jwksuri="http://localhost:8080/oauth2/jwks";

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http ) throws Exception{
        http.oauth2ResourceServer(
            r -> r.jwt(
                c->c.jwkSetUri(jwksuri)
            )
        );
    
        http.authorizeRequests().anyRequest().authenticated();

        return http.build();
    }

}

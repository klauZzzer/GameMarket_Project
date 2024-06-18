package org.example.gamemarket.configuration;

import lombok.RequiredArgsConstructor;
import org.example.gamemarket.security.UserDetailsServiceImpl;
import org.example.gamemarket.security.security_util.AccessDeniedHandlerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.example.gamemarket.security.security_util.RoleLists.*;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final UserDetailsServiceImpl userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req -> req
                        .requestMatchers(SWAGGER_LIST).permitAll()
                        .requestMatchers(ANYROLES_LIST).permitAll()
                        .requestMatchers(ADMIN_LIST).hasRole("ADMIN")
                        .requestMatchers("/developer/delete/**", "/developer/update/**").hasAnyRole("ADMIN", "DEVELOPER")
                        .anyRequest().authenticated())
                .headers(headers -> headers.cacheControl(Customizer.withDefaults()).disable())
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())
                .logout(Customizer.withDefaults())
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                        .maximumSessions(1)
                        .maxSessionsPreventsLogin(true)
                        .sessionRegistry(sessionRegistry()))
                .exceptionHandling(handler -> handler.accessDeniedHandler(new AccessDeniedHandlerImpl()))
                .build();
    }

    private SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }
}

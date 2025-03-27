package com.devsayan.springsecurity.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.PasswordManagementDsl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import java.net.http.HttpRequest;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){
        try{
            httpSecurity
                    .authorizeHttpRequests(auth->
                            auth.requestMatchers("/createPost")
                                    .hasAnyRole("ADMIN")
                                    .anyRequest()
                                    .authenticated())
                    .csrf(csrfconfig-> csrfconfig.disable())
                    .sessionManagement(sessionConfig->
                            sessionConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                    .formLogin(Customizer.withDefaults());
            return httpSecurity.build();
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
    @Bean
    UserDetailsService inMemoryUserDetailsService(){
        UserDetails normalUser = User
                .withUsername("sayan")
                .roles("USER")
                .password(passwordEncoder().encode("sayan1234"))
                .build();
        UserDetails adminUser = User.withUsername("chandrika")
                .roles("ADMIN")
                .password(passwordEncoder().encode("chandrika1234"))
                .build();
        return new InMemoryUserDetailsManager(normalUser,adminUser);
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

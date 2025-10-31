package com.AdmissionEnquiry.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    @Autowired
    private final JwtAuthFilter jwtAuthFilter; // Inject JwtAuthFilter

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Autowired
    private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .cors(cors -> cors.configurationSource(request -> {
                    var config = new org.springframework.web.cors.CorsConfiguration();
                    config.setAllowedOrigins(List.of("http://localhost:5173","https://wayabroad.in"));
                    config.setAllowedMethods(List.of("GET","POST","PUT","DELETE","OPTIONS"));
                    config.setAllowedHeaders(List.of("Authorization","Content-Type"));
                    config.setAllowCredentials(true);
                    return config;
                }))
                .authorizeHttpRequests(auth -> auth
                        // public endpoints:
                        .requestMatchers(
                                "/savecourses",
                                "/allcourses",
                                "/updatecourse/{cid}",
                                "/deletecourse/{cid}",
                                "/enquiry/{courseId}",
                                "/getallenquiry",
                                "/getenquirybyid/{id}",
                                "/deleteenquiry/{eid}",
                                "/update-enquiry/{eid}",
                                "/getall-customplan",
                                "/getplanbyid/{id}",
                                "/updateplan/{id}",
                                "/deleteplan/{id}",
                                "/customplanadd",
                                "/contactus/**"
                        ).permitAll()
                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .exceptionHandling(ex -> ex
                        .authenticationEntryPoint(customAuthenticationEntryPoint)
                )
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .httpBasic(httpBasic -> httpBasic.disable());

        return http.build();
    }

}
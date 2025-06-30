package com.userservice.sahand.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private JwtFilter jwtFilter;
    private UserDetailServiceImpl userDetailServiceImpl;

    public SecurityConfig(JwtFilter jwtFilter, UserDetailServiceImpl userDetailServiceImpl) {
        this.jwtFilter = jwtFilter;
        this.userDetailServiceImpl = userDetailServiceImpl;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable());
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.authorizeHttpRequests(authReq -> authReq
                .requestMatchers(HttpMethod.GET,"/auth/test").permitAll()
                .requestMatchers(HttpMethod.POST,"/auth/login").permitAll()
                .requestMatchers(HttpMethod.POST,"/auth/signupPerson").permitAll()
                .requestMatchers(HttpMethod.POST,"/action/add").permitAll()
                .requestMatchers(HttpMethod.POST,"/combo/add").permitAll()
                .requestMatchers(HttpMethod.POST,"/roles/add").permitAll()
                .anyRequest().authenticated());
        http.authenticationProvider(authenticationProvider());
//        http.logout(logout -> logout.logoutSuccessUrl("/users/signin/")
//                .invalidateHttpSession(true)
//                .deleteCookies("JSESSIONID")
//        );
        http.headers(headers -> headers.cacheControl(cash -> cash.disable()));
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailServiceImpl.getUserDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
}

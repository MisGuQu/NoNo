package com.example.focusflow.config;

import com.example.focusflow.model.User;
import com.example.focusflow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserRepository userRepository;

    // 1️⃣ PasswordEncoder - BCrypt
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 2️⃣ UserDetailsService - load user từ DB
    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            User user = userRepository.findByUsername(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            return org.springframework.security.core.userdetails.User
                    .withUsername(user.getUsername())
                    .password(user.getPassword())
                    .authorities("ROLE_USER")
                    .build();
        };
    }

    // 3️⃣ AuthenticationProvider
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService());
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    // 4️⃣ AuthenticationManager
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    // 5️⃣ SecurityFilterChain - cài URL public/private

    @Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .csrf().disable()
        .authorizeHttpRequests(auth -> auth
            .anyRequest().permitAll()  // 🚨 Mở toàn bộ!
        );
    return http.build();
}

    // public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    //     http
    //         .csrf().disable()
    //         .authorizeHttpRequests(auth -> auth
    //             .requestMatchers(
    //                 "/",            // Cho phép trang chủ
    //                 "/home",        // Cho phép HomeController
    //                 "/login",
    //                 "/register",
    //                 "/css/**",
    //                 "/js/**",
    //                 "/images/**"
    //             ).permitAll()
    //             .anyRequest().authenticated() // Các URL khác yêu cầu login
    //         )
    //         .formLogin(form -> form
    //             .loginPage("/login")
    //             .defaultSuccessUrl("/dashboard", true)
    //             .permitAll()
    //         )
    //         .logout(logout -> logout
    //             .logoutUrl("/logout")
    //             .logoutSuccessUrl("/login?logout")
    //             .permitAll()
    //         );

    //     return http.build();
    // }
}

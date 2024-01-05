package com.GraduationProject.graduation.config;

import com.GraduationProject.graduation.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserService userService;

    public SecurityConfig(UserService userService) {
        this.userService = userService;
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsInMemory() {
        UserDetails user1 = User
                .withUsername("SYSTEM")
                .password("password1")
                .build();
        UserDetails user2 = User.withUsername("user2")
                .password("password2")
                .build();
        return new InMemoryUserDetailsManager(user1, user2);
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests
                        (authz -> authz
                                // Преподавателите в системата могат да обработват данните в нея
                                //.requestMatchers("/students/**").hasAuthority("TEACHER")
                                //.requestMatchers("/students/**").hasAuthority("ADMIN")
                                //.requestMatchers(HttpMethod.GET,"/students").hasAuthority("STUDENT")
                                // Студентите качват единствено дипломната работа TODO:
                                .anyRequest().authenticated()
                        )
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())
        ;
        return http.build();
    }


}

package com.GraduationProject.graduation.config;

import com.GraduationProject.graduation.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserService userService;

    public SecurityConfig(UserService userService) {
        this.userService = userService;
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
                                        //for the home page
                                        .requestMatchers(HttpMethod.GET, "/").hasAnyAuthority("STUDENT", "ADMIN", "TEACHER")

                                        // students can only see the other theses and can upload their
                                        .requestMatchers(HttpMethod.GET, "/students/**").hasAnyAuthority("STUDENT", "ADMIN")
                                        .requestMatchers("/applications/create-application").hasAnyAuthority("STUDENT", "ADMIN", "TEACHER")
                                        .requestMatchers(HttpMethod.GET, "/applications").hasAnyAuthority("STUDENT", "ADMIN", "TEACHER")
                                        .requestMatchers(HttpMethod.GET, "/theses").hasAnyAuthority("STUDENT", "ADMIN", "TEACHER")
                                        .requestMatchers("/theses/create-thesis").hasAnyAuthority("STUDENT", "ADMIN", "TEACHER")
                                        // students can see all approved applications
                                        .requestMatchers("/applications/only-approved").hasAnyAuthority("STUDENT", "ADMIN", "TEACHER")
                                        .requestMatchers("/**").hasAuthority("ADMIN")
                                        .requestMatchers(HttpMethod.GET, "/**").hasAnyAuthority("TEACHER", "ADMIN")
                                        //.requestMatchers("/resources/**").permitAll() // for the front end
                                        .anyRequest().authenticated()
                                //.anyRequest().permitAll()
                        )
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())
        ;
        return http.build();
    }


}

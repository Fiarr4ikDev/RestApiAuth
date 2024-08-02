package ru.fiarr4ik.restapiauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import ru.fiarr4ik.restapiauth.services.PersonDetailsService;

    @EnableWebSecurity
    public class SecurityConfig {

        private final PersonDetailsService personDetailsService;

        public SecurityConfig(PersonDetailsService personDetailsService) {
            this.personDetailsService = personDetailsService;
        }

        @Bean
        public void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(personDetailsService)
                    .passwordEncoder(getPasswordEncoder());
        }

        @Bean
        public SecurityFilterChain springSecurityFilterChain(HttpSecurity http) throws Exception {
            http.csrf(AbstractHttpConfigurer::disable)
                    .authorizeHttpRequests((request) -> request
                            .anyRequest().permitAll()
                    );

            return http.build();
        }

        @Bean
        public PasswordEncoder getPasswordEncoder() {
            return new BCryptPasswordEncoder();
        }

    }

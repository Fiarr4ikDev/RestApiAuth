package ru.fiarr4ik.restapiauth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.fiarr4ik.restapiauth.auth.AuthenticationRequest;
import ru.fiarr4ik.restapiauth.auth.AuthenticationResponse;
import ru.fiarr4ik.restapiauth.auth.RegisterRequest;
import ru.fiarr4ik.restapiauth.data.enums.ERole;
import ru.fiarr4ik.restapiauth.data.model.User;
import ru.fiarr4ik.restapiauth.data.repo.UserRepository;

    @Service
    public class AuthenticationService {
        private final UserRepository repository;
        private final PasswordEncoder passwordEncoder;
        private final JwtService jwtService;
        private final AuthenticationManager authenticationManager;

        @Autowired
        public AuthenticationService(UserRepository repository,
                                     PasswordEncoder passwordEncoder,
                                     JwtService jwtService,
                                     AuthenticationManager authenticationManager) {
            this.repository = repository;
            this.passwordEncoder = passwordEncoder;
            this.jwtService = jwtService;
            this.authenticationManager = authenticationManager;
        }

        public AuthenticationResponse register(RegisterRequest request) {
            var user = User.builder()
                    .username(request.getUsername())
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .role(ERole.USER)
                    .build();
            repository.save(user);
            var jwtToken = jwtService.generateToken(user);
            return AuthenticationResponse.builder()
                    .token(jwtToken)
                    .build();
        }

        public AuthenticationResponse authenticate(AuthenticationRequest request) {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );
            var user = repository.findByUsername(request.getUsername())
                    .orElseThrow();
            var jwtToken = jwtService.generateToken(user);
            return AuthenticationResponse.builder()
                    .token(jwtToken)
                    .build();
        }

    }

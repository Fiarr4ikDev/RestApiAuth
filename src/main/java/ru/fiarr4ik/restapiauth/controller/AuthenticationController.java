package ru.fiarr4ik.restapiauth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.fiarr4ik.restapiauth.auth.AuthenticationRequest;
import ru.fiarr4ik.restapiauth.auth.AuthenticationResponse;
import ru.fiarr4ik.restapiauth.auth.RegisterRequest;
import ru.fiarr4ik.restapiauth.services.AuthenticationService;

    @RestController
    @RequestMapping("/auth")
    public class AuthenticationController {

        private final AuthenticationService service;

        @Autowired
        public AuthenticationController(AuthenticationService service) {
            this.service = service;
        }

        @PostMapping("/register")
        public ResponseEntity<AuthenticationResponse> register(
                @RequestBody RegisterRequest request
        ) {
            return ResponseEntity.ok(service.register(request));
        }

            @PostMapping("/authenticate")
        public ResponseEntity<AuthenticationResponse> authenticate(
                @RequestBody AuthenticationRequest request
        ) {
            return ResponseEntity.ok(service.authenticate(request));
        }
    }

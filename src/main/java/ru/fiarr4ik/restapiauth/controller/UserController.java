package ru.fiarr4ik.restapiauth.controller;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.fiarr4ik.restapiauth.data.dto.UserDTO;
import ru.fiarr4ik.restapiauth.data.entity.User;
import ru.fiarr4ik.restapiauth.services.MappingService;
import ru.fiarr4ik.restapiauth.services.RegistrationService;

    @RestController
    @RequestMapping("/user")
    public class UserController {

        private final RegistrationService registrationService;
        private final MappingService mappingService;

        @Autowired
        public UserController(RegistrationService registrationService, MappingService mappingService) {
            this.registrationService = registrationService;
            this.mappingService = mappingService;
        }

        @PostMapping("/register")
        public ResponseEntity<HttpStatus> registerUser(
                @Parameter(name = "UserDTO") @RequestBody @Valid UserDTO userDTO,
                BindingResult bindingResult
        ) {
            if (bindingResult.hasErrors()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            User user = mappingService.convertToEntity(userDTO);
            User savedUser = registrationService.registerUser(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

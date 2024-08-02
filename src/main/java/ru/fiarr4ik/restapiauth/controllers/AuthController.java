package ru.fiarr4ik.restapiauth.controllers;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.fiarr4ik.restapiauth.data.dto.PersonDTO;
import ru.fiarr4ik.restapiauth.data.models.Person;
import ru.fiarr4ik.restapiauth.security.JWTUtil;
import ru.fiarr4ik.restapiauth.services.RegistrationService;
import ru.fiarr4ik.restapiauth.util.PersonValidator;

import java.util.Map;

    @RestController
    @RequestMapping(
            value = "/auth"
    )
    public class AuthController {

        private final JWTUtil jwtUtil;
        private final ModelMapper modelMapper;
        private final RegistrationService registrationService;
        private final PersonValidator personValidator;

        @Autowired
        public AuthController(JWTUtil jwtUtil,
                              ModelMapper modelMapper,
                              RegistrationService registrationService,
                              PersonValidator personValidator) {
            this.jwtUtil = jwtUtil;
            this.modelMapper = modelMapper;
            this.registrationService = registrationService;
            this.personValidator = personValidator;
        }

        @PostMapping("/registration")
        public Map<String, String> registration(@RequestBody @Valid PersonDTO personDTO,
                                                BindingResult bindingResult) {

            Person person = convertToPerson(personDTO);

            personValidator.validate(person, bindingResult);

            if (bindingResult.hasErrors()) {
                return Map.of("Message", "Ошибка");
            }

            registrationService.register(person);

            String token = jwtUtil.generateToken(person.getUsername());
            return Map.of("token", token);
        }

        public Person convertToPerson(PersonDTO personDTO) {

            return this.modelMapper.map(personDTO, Person.class);
        }
    }

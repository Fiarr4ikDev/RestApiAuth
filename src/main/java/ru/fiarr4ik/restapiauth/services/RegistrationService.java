package ru.fiarr4ik.restapiauth.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.fiarr4ik.restapiauth.data.models.Person;
import ru.fiarr4ik.restapiauth.data.repos.PersonRepo;

    @Service
    public class RegistrationService {

        private final PersonRepo personRepo;
        private PasswordEncoder passwordEncoder;

        @Autowired
        public RegistrationService(PersonRepo personRepo) {
            this.personRepo = personRepo;
        }

        @Transactional
        public void register(Person person) {
            person.setPassword(passwordEncoder.encode(person.getPassword()));
            person.setRole("USER");
            personRepo.save(person);
        }
    }

package ru.fiarr4ik.restapiauth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.fiarr4ik.restapiauth.data.models.Person;
import ru.fiarr4ik.restapiauth.data.repos.PersonRepo;
import ru.fiarr4ik.restapiauth.security.PersonDetails;

import java.util.Optional;

    @Service
    public class PersonDetailsService implements UserDetailsService {

        private final PersonRepo personRepo;

        @Autowired
        public PersonDetailsService(PersonRepo personRepo) {
            this.personRepo = personRepo;
        }

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            Optional<Person> person = personRepo.findByUsername(username);

            if (person.isEmpty()) {
                throw new UsernameNotFoundException("Пользователь не найден");
            }

            return new PersonDetails(person.get());
        }
    }

package ru.fiarr4ik.restapiauth.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import ru.fiarr4ik.restapiauth.data.models.Person;
import ru.fiarr4ik.restapiauth.services.PersonDetailsService;

    @Component
    public class PersonValidator implements Validator {

        private final PersonDetailsService personDetailsService;

        @Autowired
        public PersonValidator(PersonDetailsService personDetailsService) {
            this.personDetailsService = personDetailsService;
        }

        @Override
        public boolean supports(Class<?> aClass) {
            return Person.class.equals(aClass);
        }

        @Override
        public void validate(Object target, org.springframework.validation.Errors errors) {
            Person person = (Person) target;

            try {
                personDetailsService.loadUserByUsername(person.getUsername());
            } catch (UsernameNotFoundException e) {
                return;
            }

            errors.rejectValue("username", null, "Username not found");
        }

    }

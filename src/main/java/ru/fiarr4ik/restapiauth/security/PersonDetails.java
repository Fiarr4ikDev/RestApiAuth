package ru.fiarr4ik.restapiauth.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.fiarr4ik.restapiauth.data.models.Person;

import java.util.Collection;

    public class PersonDetails implements UserDetails {

        private final Person person;

        public PersonDetails(Person person) {
            this.person = person;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return null;
        }

        @Override
        public String getPassword() {
            return this.person.getPassword();
        }

        @Override
        public String getUsername() {
            return this.person.getUsername();
        }
    }

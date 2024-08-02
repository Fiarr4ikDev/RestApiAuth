package ru.fiarr4ik.restapiauth.data.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.fiarr4ik.restapiauth.data.models.Person;

import java.util.Optional;

    @Repository
    public interface PersonRepo extends JpaRepository<Person, Integer> {

        Optional<Person> findByUsername(String username);
    }

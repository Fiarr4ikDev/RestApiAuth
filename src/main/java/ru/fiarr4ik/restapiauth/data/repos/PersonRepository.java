package ru.fiarr4ik.restapiauth.data.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.fiarr4ik.restapiauth.data.models.Person;

import java.util.Optional;

    /**
     * Репозиторий для работы с таблицой базы данных пользователя.
     */
    @Repository
    public interface PersonRepository extends JpaRepository<Person, Long> {

        Optional<Person> findByUsername(String username);

    }

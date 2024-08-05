package ru.fiarr4ik.restapiauth.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.fiarr4ik.restapiauth.data.entity.User;

import java.util.Optional;

    @Repository
    public interface UserRepository extends JpaRepository<User, Long> {

        Optional<User> findByUsername(String username);
    }

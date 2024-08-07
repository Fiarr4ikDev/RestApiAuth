package ru.fiarr4ik.restapiauth.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.fiarr4ik.restapiauth.data.model.User;

import java.util.Optional;

    @Repository
    public interface UserRepository extends JpaRepository<User, Integer> {
        Optional<User> findByUsername(String username);
    }

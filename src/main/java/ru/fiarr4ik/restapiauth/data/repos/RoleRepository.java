package ru.fiarr4ik.restapiauth.data.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.fiarr4ik.restapiauth.data.models.Role;

import java.util.Optional;

/**
     * Репозиторий для работы с таблицой базы данных ролей пользователя.
     */
    @Repository
    public interface RoleRepository extends JpaRepository<Role, Long> {

        Optional<Role> findById(Long id);

    }

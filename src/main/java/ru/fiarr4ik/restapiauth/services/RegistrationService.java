package ru.fiarr4ik.restapiauth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fiarr4ik.restapiauth.data.entity.User;
import ru.fiarr4ik.restapiauth.data.repository.UserRepository;
import ru.fiarr4ik.restapiauth.enums.ERole;

@Service
    public class RegistrationService {

        private final UserRepository userRepository;

        @Autowired
        public RegistrationService(UserRepository userRepository, MappingService mappingService) {
            this.userRepository = userRepository;

        }

        public User registerUser(User user) {
            user.setERole(ERole.USER);
            return userRepository.save(user);
        }
    }

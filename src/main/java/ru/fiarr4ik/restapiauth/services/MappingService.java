package ru.fiarr4ik.restapiauth.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fiarr4ik.restapiauth.data.dto.UserDTO;
import ru.fiarr4ik.restapiauth.data.entity.User;

    @Service
    public class MappingService {

        private final ModelMapper modelMapper;

        @Autowired
        public MappingService(ModelMapper modelMapper) {
            this.modelMapper = modelMapper;
        }

        public User convertToEntity(UserDTO userDTO) {
            return modelMapper.map(userDTO, User.class);
        }

        public UserDTO convertToDto(User user) {
            return modelMapper.map(user, UserDTO.class);
        }
    }

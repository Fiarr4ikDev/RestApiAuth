package ru.fiarr4ik.restapiauth.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fiarr4ik.restapiauth.data.dto.PersonDTO;
import ru.fiarr4ik.restapiauth.data.dto.RoleDTO;
import ru.fiarr4ik.restapiauth.data.models.Person;
import ru.fiarr4ik.restapiauth.data.models.Role;

    /**
     * Сервис для маппинга сущностей в DTO и обратно.
     */
    @Service
    public class ModelMappingService {

        private final ModelMapper modelMapper;

        @Autowired
        public ModelMappingService(ModelMapper modelMapper) {
            this.modelMapper = modelMapper;
        }

        public PersonDTO convertToDTO(Person person) {
            return modelMapper.map(person, PersonDTO.class);
        }

        public Person convertToEntity(PersonDTO personDTO) {
            return modelMapper.map(personDTO, Person.class);
        }

        public RoleDTO convertToDTO(Role role) {
            return modelMapper.map(role, RoleDTO.class);
        }

        public Role convertToEntity(RoleDTO roleDTO) {
            return modelMapper.map(roleDTO, Role.class);
        }

    }

package ru.fiarr4ik.restapiauth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fiarr4ik.restapiauth.data.dto.PersonDTO;
import ru.fiarr4ik.restapiauth.data.models.Person;
import ru.fiarr4ik.restapiauth.data.models.Role;
import ru.fiarr4ik.restapiauth.data.repos.PersonRepository;
import ru.fiarr4ik.restapiauth.data.repos.RoleRepository;

    /**
     * Сервис для работы с пользователями.
     */
    @Service
    public class PersonService {

        private final PersonRepository personRepository;
        private final RoleRepository roleRepository;
        private final ModelMappingService modelMappingService;

        /**
         * Конструктор с внедрением зависимостей.
         * @param personRepository репозиторий пользователей.
         * @param modelMappingService сервис для маппинга.
         * @param roleRepository репозиторий ролей пользователя.
         */
        @Autowired
        public PersonService(PersonRepository personRepository,
                             ModelMappingService modelMappingService,
                             RoleRepository roleRepository) {
            this.personRepository = personRepository;
            this.modelMappingService = modelMappingService;
            this.roleRepository = roleRepository;
        }

        /**
         * Метод для сохранения пользователя.
         * @param personDTO экземпляр класса пользователя.
         * @return сконвертированная в DTO сущность savedPerson.
         */
        public PersonDTO savePerson(PersonDTO personDTO) {
            Person person = modelMappingService.convertToEntity(personDTO);
            Role defaultRole = roleRepository.findById(1L).orElseThrow(() -> new RuntimeException("Role not found"));
            person.setRole(defaultRole);
            Person savedPerson = personRepository.save(person);
            return modelMappingService.convertToDTO(savedPerson);
        }
    }

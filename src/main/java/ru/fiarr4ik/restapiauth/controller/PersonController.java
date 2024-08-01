package ru.fiarr4ik.restapiauth.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.fiarr4ik.restapiauth.data.dto.PersonDTO;
import ru.fiarr4ik.restapiauth.services.PersonService;
import ru.fiarr4ik.restapiauth.utils.exceptions.PersonSaveErrorException;

import java.util.List;

    /**
     * Контроллер для работы с пользователями.
     */
    @RestController
    @RequestMapping("/auth")
    @Tag(
            name = "Контроллер для пользователей."
    )
    public class PersonController {

        private final PersonService personService;

        /**
         * Конструктор с внедрением зависимостей.
         * @param personService сервис для работы с пользователями.
         */
        @Autowired
        public PersonController(PersonService personService) {
            this.personService = personService;
        }

        /**
         * Метод для сохранения пользователя.
         * @param personDTO DTO пользователя.
         * @param bindingResult Валидатор.
         * @return {@link HttpStatus#OK} если всё прошло успешно.
         */
        @Operation(
                summary = "Регистрация пользователя."
        )
        @PutMapping("/signup")
        public ResponseEntity<HttpStatus> savePerson(
            @Parameter(description = "Экземпляр DTO пользователя.") @RequestBody @Valid PersonDTO personDTO,
            BindingResult bindingResult
        ) {
            if (bindingResult.hasErrors()) {
                StringBuilder errorMsg = new StringBuilder();

                List<FieldError> errors = bindingResult.getFieldErrors();
                for (FieldError error : errors) {
                    errorMsg.append(error.getField())
                            .append(" - ")
                            .append(error.getDefaultMessage())
                            .append("; ");
                }

                throw new PersonSaveErrorException(errorMsg.toString());
            }

            personService.savePerson(personDTO);
            return ResponseEntity.ok(HttpStatus.OK);
        }
    }

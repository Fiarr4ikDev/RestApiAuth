package ru.fiarr4ik.restapiauth.utils.exceptions.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.fiarr4ik.restapiauth.utils.PersonErrorResponse;
import ru.fiarr4ik.restapiauth.utils.exceptions.PersonSaveErrorException;

    /**
     * Обработчик ошибок пользователей.
     */
    public class PersonExceptionsHandler {

        /**
         * Обработка ошибки {@link PersonSaveErrorException}.
         * @param e исключение.
         * @return ответ и {@link HttpStatus#BAD_REQUEST}.
         */
        @ExceptionHandler
        public ResponseEntity<PersonErrorResponse> handlePersonSaveError(PersonSaveErrorException e) {
            PersonErrorResponse response = new PersonErrorResponse(
                    System.currentTimeMillis(),
                    e.getMessage()
            );
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

    }

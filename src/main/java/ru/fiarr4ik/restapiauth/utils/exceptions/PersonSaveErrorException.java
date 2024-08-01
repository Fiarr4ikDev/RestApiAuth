package ru.fiarr4ik.restapiauth.utils.exceptions;

    /**
     * Исключение, которое выбрасывается при ошибке сохранения пользователя.
     */
    public class PersonSaveErrorException extends RuntimeException {

        public PersonSaveErrorException(String msg) {
            super(msg);
        }

    }

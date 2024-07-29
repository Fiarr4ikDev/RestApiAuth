package ru.fiarr4ik.restapiauth;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

    @SuppressWarnings("checkstyle:HideUtilityClassConstructor")
    @SpringBootApplication
    @OpenAPIDefinition(
            info = @Info(
                    title = "AuthApi",
                    description = "Spring boot REST API (auth) для аутентификации и авторизации пользователей.",
                    version = "0.0.1",
                    contact = @Contact(
                            name = "Fiarr4ikDev",
                            email = "fiarr4ikdev@gmail.com",
                            url = """
                                    https://github.com/Velier12/RestApiAuth"""
                    )
            )
    )
    public class RestApiAuthApplication {

        public static void main(String[] args) {
            SpringApplication.run(RestApiAuthApplication.class, args);
        }

    }

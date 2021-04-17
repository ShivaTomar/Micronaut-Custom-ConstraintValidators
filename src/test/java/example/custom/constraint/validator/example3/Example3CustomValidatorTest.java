package example.custom.constraint.validator.example3;


import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import lombok.var;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.Set;

import static io.micronaut.http.HttpRequest.POST;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class Example3CustomValidatorTest {

    @Inject
    Validator validator;

    @Inject
    @Client("/root")
    RxHttpClient client;

    @Inject
    RegisterUserService registerUserService;

    @Test
    void badRequestRootControllerTest() {
        var response = client.exchange(
                POST("", new RegistrationUser(
                        "IzDummy",
                        "http://www.IzDummy.com",
                        "",
                        1)
                ), RegistrationUser.class
        ).blockingFirst();

        assertNotNull(response.body());
        assertEquals(HttpStatus.OK, response.status());
    }

    @Test
    void subDomainAndProtocolTest() {
        final ConstraintViolationException exception = assertThrows(ConstraintViolationException.class, () ->
                registerUserService.isValid(new RegistrationUser(
                        "IzDummy",
                        "",
                        "",
                        1)
                )
        );

        assertEquals("default message", exception.getMessage());
    }

    @Test
    void constraintExceptionTest() {
        RegistrationUser registrationUser = new RegistrationUser("IzDummy", "http://www.IzDummy.com", "", 1);

        Set<ConstraintViolation<RegistrationUser>> constraintViolations = validator.validate(
                registrationUser, Order.class);

        if (constraintViolations.size() > 0) {
            constraintViolations.stream().forEach(System.out::println);
        } else {
            System.out.println(registrationUser);
        }
    }
}

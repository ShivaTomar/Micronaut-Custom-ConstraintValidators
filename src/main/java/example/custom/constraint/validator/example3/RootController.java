package example.custom.constraint.validator.example3;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.RequestBean;
import lombok.extern.slf4j.Slf4j;

import javax.validation.Valid;

@Controller("/root")
@Slf4j
public class RootController {

    @Post
    public RegistrationUser validate(@Valid @RequestBean RegistrationUser registrationUser) {
        log.info("validated successfully.");
        return registrationUser;
    }
}

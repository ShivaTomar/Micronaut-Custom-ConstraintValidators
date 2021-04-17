package example.custom.constraint.validator.example3;

import javax.inject.Singleton;
import javax.validation.Valid;

@Singleton
public class RegisterUserService {

    public RegistrationUser isValid(@Valid RegistrationUser registrationUser) {
        return registrationUser;
    }
}

package example.custom.constraint.validator.example1;

import javax.inject.Singleton;
import javax.validation.Valid;

@Singleton
public class UserService {

    public String isValidUser(@Valid User user) {
        return "Valid user.";
    }
}

package example.custom.constraint.validator.example1;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LastNameConstraintvalidator implements ConstraintValidator<LastName, User> {

    @Override
    public boolean isValid(User value, ConstraintValidatorContext context) {

        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate("This is a custom message for last name.").addConstraintViolation();

        return false;
    }
}

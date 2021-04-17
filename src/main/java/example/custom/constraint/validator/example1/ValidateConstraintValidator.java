package example.custom.constraint.validator.example1;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidateConstraintValidator implements ConstraintValidator<Validate, User> {

    private String fieldName;

    @Override
    public void initialize(final Validate constraintAnnotation) {
        fieldName = constraintAnnotation.fieldName();
    }

    @Override
    public boolean isValid(User value, ConstraintValidatorContext context) {

        System.out.println("field: " +fieldName);
        System.out.println("firstname:" +value.lastName);
        System.out.println("lastname:" +value.firstName);

        if (fieldName.equals("firstName") && value.firstName.equals("shiva")) {
            return true;
        }

        return fieldName.equals("lastName") && value.lastName.equals("tomar");
    }
}

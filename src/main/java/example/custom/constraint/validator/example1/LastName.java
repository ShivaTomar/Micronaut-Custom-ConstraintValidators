package example.custom.constraint.validator.example1;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Constraint(validatedBy = {LastNameConstraintvalidator.class})
public @interface LastName {
    String message() default "Invalid lastname.";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}

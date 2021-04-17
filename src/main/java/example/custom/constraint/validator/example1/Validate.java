package example.custom.constraint.validator.example1;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Constraint(validatedBy = {ValidateConstraintValidator.class})
public @interface Validate {
    String message() default "{example.custom.constraint.validator.core.Validate.message}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

    String fieldName();

    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        Validate[] value();
    }
}

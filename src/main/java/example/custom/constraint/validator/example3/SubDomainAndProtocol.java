package example.custom.constraint.validator.example3;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Constraint(validatedBy = {SubDomainAndProtocolConstraintValidator.class})
public @interface SubDomainAndProtocol {
    String message() default "{iz.middleware.signup.SubDomainAndProtocol.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String firstField();

    String secondField();

    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        SubDomainAndProtocol[] value();
    }
}

package example.custom.constraint.validator.example1;

import io.micronaut.core.annotation.Introspected;

import javax.validation.constraints.NotBlank;

@Introspected
@Validate.List(value = {
   @Validate(fieldName = "firstName", message = "first name can only be shiva."),
   @Validate(fieldName = "lastName", message = "last name can only be tomar.")
})

//@LastName(groups = {Group2.class})
//@GroupSequence({User.class, Group1.class, Group2.class})
public class User {
    //@NotBlank(groups = Group1.class)
    @NotBlank
    String firstName;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @NotBlank
    String lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}

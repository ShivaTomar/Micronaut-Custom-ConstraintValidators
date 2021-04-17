package example.custom.constraint.validator.example3;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.Nullable;
import lombok.*;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Introspected
@ToString
@SubDomainAndProtocol.List(value = {
	@SubDomainAndProtocol(firstField = "protocol", secondField = "websiteUrl", message = "Invalid Protocol.", groups = First.class),
	@SubDomainAndProtocol(firstField = "subdomain_name", secondField = "websiteUrl", message = "Invalid Subdomain.", groups = Second.class)
})
@GroupSequence({RegistrationUser.class, First.class, Second.class})
public class RegistrationUser {
	@NotBlank
	String name;

	@NotBlank
	@Size(min = 1, max = 253)
	String websiteUrl;

	@Nullable
	String subdomain_name;

	@NotNull
	int protocol;
}

package example.custom.constraint.validator.example3;

import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.NotNull;

@Slf4j
public class SubDomainAndProtocolConstraintValidator implements ConstraintValidator<SubDomainAndProtocol, RegistrationUser> {

    private String firstField;
    private String secondField;

    @Override
    public void initialize(SubDomainAndProtocol constraintAnnotation) {
        this.firstField = constraintAnnotation.firstField();
        this.secondField = constraintAnnotation.secondField();
    }

    @Override
    public boolean isValid(@NotNull RegistrationUser value, ConstraintValidatorContext context) {
        String url = value.websiteUrl;
        String protocol = ExtractWebsiteUrlDetails.extractUrlProtocol(url);

        log.info(url);
        log.info(protocol);

        log.info(firstField);
        log.info(secondField);

        if(!ExtractWebsiteUrlDetails.isValidWebsite(url)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Invalid Website Url.").addConstraintViolation();
            return false;
        }

        if(firstField.equals("protocol") && secondField.equals("websiteUrl")) {
            return value.protocol == 1 ? protocol.equals("https:") : value.protocol == 0 && protocol.equals("http:");
        }

        if (firstField.equals("subdomain_name") && secondField.equals("websiteUrl")) {

            if (value.subdomain_name == null || value.subdomain_name.isEmpty()) {
                return protocol.equals("https:");
            }

            if (protocol.equals("http:")) {
                return value.subdomain_name.equals(ExtractWebsiteUrlDetails.extractSubDomain(url));
            }
        }

        return false;
    }
}

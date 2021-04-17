package example.custom.constraint.validator.example2;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;

public class EnrolmentValidator implements ConstraintValidator<EnrolmentValid, Object> {

    private String personNoFieldName;
    private String departmentNoFieldName;

    @Override
    public void initialize(final EnrolmentValid a) {
        this.personNoFieldName = a.personNoFieldName();
        this.departmentNoFieldName = a.departmentNoFieldName();
    }

    @Override
    public boolean isValid(final Object t, final ConstraintValidatorContext cvc) {
        final Object personNo;
        final Object departmentNo;
        try {
            personNo = BeanUtils.getProperty(t, this.personNoFieldName);
            departmentNo = BeanUtils.getProperty(t, this.departmentNoFieldName);

        } catch (final Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }

        if (personNo == null || departmentNo == null) { return true; }

        return false;
    }
}
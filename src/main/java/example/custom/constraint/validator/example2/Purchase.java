package example.custom.constraint.validator.example2;

import javax.validation.constraints.NotNull;

@EnrolmentValid.List(value = {
        @EnrolmentValid(
                personNoFieldName = "authorisePersonNo",
                departmentNoFieldName = "authorisationDepartmentNo",
                message="Authoriser does not belong to the auth department"
        ),
        @EnrolmentValid(
                personNoFieldName = "payerPersonNo",
                departmentNoFieldName = "paymentDepartmentNo",
                message="Payer does not belong to the payment department"
        )
})
public class Purchase {

    private Integer authorisePersonNo;
    private Integer payerPersonNo;

    @NotNull
    private Integer authorisationDepartmentNo;

    @NotNull
    private Integer paymentDepartmentNo;

    public Purchase(Integer authorisePersonNo, Integer payerPersonNo, @NotNull Integer authorisationDepartmentNo, @NotNull Integer paymentDepartmentNo) {
        this.authorisePersonNo = authorisePersonNo;
        this.payerPersonNo = payerPersonNo;
        this.authorisationDepartmentNo = authorisationDepartmentNo;
        this.paymentDepartmentNo = paymentDepartmentNo;
    }

    public Integer getAuthorisePersonNo() {
        return authorisePersonNo;
    }

    public Integer getPayerPersonNo() {
        return payerPersonNo;
    }

    public Integer getAuthorisationDepartmentNo() {
        return authorisationDepartmentNo;
    }

    public Integer getPaymentDepartmentNo() {
        return paymentDepartmentNo;
    }
}

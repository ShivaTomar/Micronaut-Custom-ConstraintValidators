package example.custom.constraint.validator.example2;

import javax.inject.Singleton;
import javax.validation.Valid;

@Singleton
public class PurchaseService {

    public String isValidUser(@Valid Purchase purchase) {
        return "Valid purchase.";
    }
}

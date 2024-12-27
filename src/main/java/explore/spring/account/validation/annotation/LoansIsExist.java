package explore.spring.account.validation.annotation;


import explore.spring.account.validation.validator.LoansIsExistValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = LoansIsExistValidator.class)
@Target({ FIELD,  PARAMETER, TYPE})
public @interface LoansIsExist {
    String message() default "Loan is not found";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}

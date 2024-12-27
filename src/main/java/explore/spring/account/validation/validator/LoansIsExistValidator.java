package explore.spring.account.validation.validator;

import explore.spring.account.entity.Loans;
import explore.spring.account.provider.LoanProvider;
import explore.spring.account.validation.annotation.LoansIsExist;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
@Slf4j
public class LoansIsExistValidator implements ConstraintValidator<LoansIsExist,String> {

    private final LoanProvider loanProvider;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        Loans loans = loanProvider.findByLoanNumber(value);
        return Objects.nonNull(loans);
    }
}

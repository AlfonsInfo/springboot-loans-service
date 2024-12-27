package explore.spring.account.provider;

import explore.spring.account.entity.Loans;
import explore.spring.account.repository.LoansRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@RequestScope
@RequiredArgsConstructor
@Component
public class LoanProvider {
    private final LoansRepository loansRepository;
    private Loans loans;

    public Loans findByLoanNumber(String loanNumber){
        if(loans == null){loans = loansRepository.findByLoanNumber(loanNumber);}
        return loans;
    }



}

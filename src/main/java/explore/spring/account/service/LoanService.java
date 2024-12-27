package explore.spring.account.service;


import explore.spring.account.dto.loans.RequestLoansDto;
import explore.spring.account.entity.Loans;
import explore.spring.account.mapper.LoanMapper;
import explore.spring.account.provider.LoanProvider;
import explore.spring.account.repository.LoansRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoanService {
    // repository
    private final LoansRepository loansRepository;
    // provider
    private final LoanProvider loanProvider;
    // mapper
    private final LoanMapper loanMapper;

    @Transactional
    public void createLoans(RequestLoansDto request){
        Loans loans = loanMapper.mapToLoans(request);
        loansRepository.save(loans);
    }

    @Transactional
    public void updateLoans(String loanNumber, RequestLoansDto request){
        Loans loans = loanProvider.findByLoanNumber(loanNumber);
        loans.setMobileNumber(request.getMobileNumber());
        loans.setLoanNumber(request.getLoanNumber());
        loans.setLoanType(request.getLoanType());
        loans.setTotalLoan(request.getTotalLoan());
        loans.setAmountPaid(request.getAmountPaid());
        loans.setOutstandingAmount(request.getOutstandingAmount());
        loansRepository.save(loans);
    }



}

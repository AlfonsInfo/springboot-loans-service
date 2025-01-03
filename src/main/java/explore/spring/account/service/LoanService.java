package explore.spring.account.service;


import explore.spring.account.dto.loans.RequestLoansDto;
import explore.spring.account.dto.loans.ResponseLoansDto;
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
        loanMapper.updateLoanFromDto(request,loans);
        loansRepository.save(loans);
    }

    public ResponseLoansDto getDetailLoans(String loanNumber){
        Loans loans = loanProvider.findByLoanNumber(loanNumber);
        return loanMapper.mapToRespLoansDto(loans);
    }

    public void deleteLoans(String loanNumber){
        Loans loans = loanProvider.findByLoanNumber(loanNumber);
        loansRepository.delete(loans);
    }


}

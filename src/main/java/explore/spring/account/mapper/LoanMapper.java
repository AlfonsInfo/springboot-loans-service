package explore.spring.account.mapper;


import explore.spring.account.dto.loans.RequestLoansDto;
import explore.spring.account.entity.Loans;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LoanMapper {
    Loans mapToLoans(RequestLoansDto request);
}

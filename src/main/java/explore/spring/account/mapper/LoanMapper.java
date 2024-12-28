package explore.spring.account.mapper;


import explore.spring.account.dto.loans.RequestLoansDto;
import explore.spring.account.dto.loans.ResponseLoansDto;
import explore.spring.account.entity.Loans;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface LoanMapper {
    Loans mapToLoans(RequestLoansDto request);
    ResponseLoansDto mapToRespLoansDto(Loans loans);

    @Mapping(target = "loanNumber", ignore = true)
    void updateLoanFromDto(RequestLoansDto loanUpdateDTO, @MappingTarget Loans loan);
}

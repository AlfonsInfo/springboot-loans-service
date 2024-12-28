package explore.spring.account.controller;

import explore.spring.account.constant.StatusMessage;
import explore.spring.account.dto.ResponseDto;
import explore.spring.account.dto.loans.RequestLoansDto;
import explore.spring.account.dto.loans.ResponseLoansDto;
import explore.spring.account.service.LoanService;
import explore.spring.account.validation.annotation.LoansIsExist;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/v1/loans")
@AllArgsConstructor
@Validated
@Tag(name = "CRUD REST APIs for Loans", description = "CREATE, READ, UPDATE, DELETE")
public class    LoanController {

    private final LoanService loanService;

    @Operation(summary = "Create Loans")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseDto<Void> createLoans(@RequestBody @Validated RequestLoansDto request){
        loanService.createLoans(request);
        return ResponseDto.<Void>builder()
                .statusCode(HttpStatus.CREATED.value())
                .statusMsg(StatusMessage.SUCCESS_CREATE_LOANS)
                .build();
    }

    @Operation(summary = "Update Loans")
    @PutMapping("/{loanNumber}")
    @ResponseStatus(HttpStatus.OK)
    ResponseDto<Void> updateLoans(
            @PathVariable @LoansIsExist String loanNumber,
            @RequestBody RequestLoansDto requestLoansDto
    ){
        loanService.updateLoans(loanNumber, requestLoansDto);
        return ResponseDto.<Void>builder()
                .statusCode(HttpStatus.OK.value())
                .statusMsg(StatusMessage.SUCCESS_UPDATED_LOANS)
                .build();
    }

    @Operation(summary = "Get Detail Loans")
    @GetMapping("/{loanNumber}")
    ResponseDto<ResponseLoansDto> getDetailLoans(
            @PathVariable @LoansIsExist String loanNumber
    ){
        return ResponseDto.<ResponseLoansDto>builder()
                .data(loanService.getDetailLoans(loanNumber))
                .statusCode(HttpStatus.OK.value())
                .statusMsg(StatusMessage.SUCCESS_GET_LOANS)
                .build();
    }


    @Operation(summary = "Delete Loans")
    @DeleteMapping("/{loanNumber}")
    ResponseDto<Void> deleteLoans(
            @PathVariable @LoansIsExist String loanNumber
    ){
        loanService.deleteLoans(loanNumber);
        return ResponseDto.<Void>builder()
                .statusCode(HttpStatus.OK.value())
                .statusMsg(StatusMessage.SUCCESS_DELETE_LOANS)
                .build();
    }


}

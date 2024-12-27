package explore.spring.account.configuration;


import explore.spring.account.dto.ErrorResponseDto;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;


@Slf4j
@RestControllerAdvice
public class ServiceExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("MethodArgumentNotValidException: {}", e.getMessage());
        return ResponseEntity.badRequest().body(ErrorResponseDto.builder()
                .errorMsg(e.getMessage())
                .errors(
                        e.getBindingResult()
                                .getFieldErrors()
                                .stream()
                                .map(this::buildFieldErrorMessage)
                                .toList()
                )
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .build());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponseDto> handleConstraintViolationException(ConstraintViolationException e) {
        log.error("ConstraintViolationException: {}", e.getMessage());
        return ResponseEntity.badRequest().body(ErrorResponseDto.builder()
                .errorMsg(e.getMessage())
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .build());
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrorResponseDto> handleResponseStatusException(ResponseStatusException e) {
        log.error("ResponseStatusException: {}", e.getMessage());
        return ResponseEntity.status(e.getStatusCode()).body(ErrorResponseDto.builder()
                .errorMsg(e.getMessage())
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .build());
    }

    private String buildFieldErrorMessage(FieldError fieldError) {
        return fieldError.getField() + " "+ fieldError.getDefaultMessage();
    }

}


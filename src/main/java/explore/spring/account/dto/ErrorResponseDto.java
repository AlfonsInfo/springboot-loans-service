package explore.spring.account.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseDto {
    @Schema(description = "Status code in the response",example = "400")
    private Integer statusCode;
    @Schema(description = "Error message in the response", example = "Error at xxx")
    private String errorMsg;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> errors;
}

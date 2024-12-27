package explore.spring.account.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto<T> {
    @Schema(description = "Status code in the response",example = "200")
    private Integer statusCode;
    @Schema(description = "message in the response", example = "Success do action")
    private String statusMsg;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;
}

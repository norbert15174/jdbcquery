package pl.jdbcqueryexample.jdbcquery.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ErrorMessage {

    @JsonInclude(NON_NULL)
    private String field;
    private String errorMsg;

    public ErrorMessage(String defaultMessage) {
        this.errorMsg = defaultMessage;
    }
}

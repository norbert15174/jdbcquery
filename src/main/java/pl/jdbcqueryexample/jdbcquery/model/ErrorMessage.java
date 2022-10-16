package pl.jdbcqueryexample.jdbcquery.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ErrorMessage {

    private String field;
    private String errorMsg;

    public ErrorMessage(String defaultMessage) {
        this.errorMsg = defaultMessage;
    }
}

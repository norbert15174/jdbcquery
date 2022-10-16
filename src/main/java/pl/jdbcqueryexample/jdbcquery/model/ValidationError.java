package pl.jdbcqueryexample.jdbcquery.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ValidationError {

    private Integer code;
    private String message;
    private List <ErrorMessage> errorMessages = new ArrayList <>();

}

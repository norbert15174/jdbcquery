package pl.jdbcqueryexample.jdbcquery.exception;

import lombok.Getter;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ValidationObjectException extends RuntimeException {

    private Errors errors;

    public ValidationObjectException(final Errors errors) {
        super();
        this.errors = errors;
    }

    @Override
    public String toString() {
        List <String> validationErrors = new ArrayList <>();
        for (ObjectError error : this.errors.getAllErrors()) {
            if ( error instanceof FieldError ) {
                String errorMsg = ((FieldError) error).getField() + " : " + error.getCode();
                validationErrors.add(errorMsg);
                continue;
            }
            validationErrors.add(error.toString());
        }
        return validationErrors.toString();
    }
}

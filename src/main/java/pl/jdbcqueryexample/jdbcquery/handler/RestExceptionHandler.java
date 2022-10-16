package pl.jdbcqueryexample.jdbcquery.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.jdbcqueryexample.jdbcquery.exception.EntityNotFoundException;
import pl.jdbcqueryexample.jdbcquery.exception.ValidationObjectException;
import pl.jdbcqueryexample.jdbcquery.model.ErrorMessage;
import pl.jdbcqueryexample.jdbcquery.model.ValidationError;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@ControllerAdvice(basePackages = "pl.jdbcqueryexample.jdbcquery.controller")
public class RestExceptionHandler {

    @ExceptionHandler({ValidationObjectException.class})
    public ResponseEntity <?> handleValidationObjectException(ValidationObjectException ex) {

        List <ErrorMessage> errorMessages = new ArrayList <>();
        ex.getErrors().getAllErrors().forEach(
                objectError -> {
                    if ( objectError instanceof FieldError ) {
                        var object = (FieldError) objectError;
                        errorMessages.add(new ErrorMessage(object.getField() , Objects.requireNonNull(object.getCode()).toString()));
                    } else {
                        errorMessages.add(new ErrorMessage(objectError.getCode()));
                    }
                }
        );
        final var error = new ValidationError(HttpStatus.BAD_REQUEST.value() , "validation error" , errorMessages);
        return new ResponseEntity <>(error , HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity <?> handleValidationObjectException(EntityNotFoundException ex) {
        return new ResponseEntity <>(ex.getMessage() , HttpStatus.BAD_REQUEST);
    }

}

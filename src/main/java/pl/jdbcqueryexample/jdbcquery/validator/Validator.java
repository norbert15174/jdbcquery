package pl.jdbcqueryexample.jdbcquery.validator;

import com.google.common.base.Strings;
import org.springframework.validation.Errors;

public class Validator {

    protected void validateStringEmpty(String key , String value , Errors errors) {
        if ( Strings.isNullOrEmpty(value) ) {
            errors.rejectValue(key , "Field cannot be null");
        }
    }

}

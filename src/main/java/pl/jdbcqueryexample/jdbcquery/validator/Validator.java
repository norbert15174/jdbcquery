package pl.jdbcqueryexample.jdbcquery.validator;

import com.google.common.base.Strings;
import org.springframework.validation.Errors;
import pl.jdbcqueryexample.jdbcquery.repository.IGetOpt;

import java.util.Optional;

public class Validator {

    protected void validateStringEmpty(String key , String value , Errors errors) {
        if ( Strings.isNullOrEmpty(value) ) {
            errors.rejectValue(key , "Field cannot be null");
        }
    }

    protected <T> Optional <T> validateGetOptEntityExist(IGetOpt getOptService , Long id , Errors errors) {
        Optional <T> entityOpt = getOptService.getByIdOpt(id);
        if ( entityOpt.isEmpty() ) {
            errors.reject(String.format("Object with id : %d does not exist" , id));
        }
        return entityOpt;
    }

}

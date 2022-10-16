package pl.jdbcqueryexample.jdbcquery.validator;

import com.google.common.base.Strings;
import org.springframework.validation.Errors;
import pl.jdbcqueryexample.jdbcquery.repository.base.IGetOpt;

import java.util.Objects;
import java.util.Optional;

public class Validator {

    protected void validateStringEmpty(String key , String value , Errors errors) {
        if ( Strings.isNullOrEmpty(value) ) {
            errors.rejectValue(key , "Field cannot be null");
        }
    }

    protected void validateObjectNonNull(String key , Object value , Errors errors) {
        if ( Objects.isNull(value) ) {
            errors.rejectValue(key , "Field cannot be null");
        }
    }

    protected <T> Optional <T> validateGetOptEntityExist(IGetOpt getOptService , Long id , Errors errors) {
        Optional <T> entityOpt = getOptService.getByIdOpt(id);
        if ( entityOpt.isEmpty() ) {
            errors.reject(String.format("Object id : %d does not exist" , id));
        }
        return entityOpt;
    }

    protected <T> Optional <T> validateGetOptEntityExist(String key , IGetOpt getOptService , Long id , Errors errors) {
        Optional <T> entityOpt = getOptService.getByIdOpt(id);
        if ( entityOpt.isEmpty() ) {
            errors.rejectValue(key , String.format("Object id : %d does not exist" , id));
        }
        return entityOpt;
    }

}

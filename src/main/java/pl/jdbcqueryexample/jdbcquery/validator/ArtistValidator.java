package pl.jdbcqueryexample.jdbcquery.validator;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import pl.jdbcqueryexample.jdbcquery.dto.ArtistCreateDTO;

@AllArgsConstructor
@Component
public class ArtistValidator extends Validator {

    public void validateCreate(ArtistCreateDTO dto , Errors errors) {
        validateStringEmpty("name" , dto.getName() , errors);
        validateStringEmpty("lastName" , dto.getLastName() , errors);
        validateStringEmpty("nickname" , dto.getNickname() , errors);
    }

}

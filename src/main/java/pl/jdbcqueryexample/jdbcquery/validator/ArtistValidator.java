package pl.jdbcqueryexample.jdbcquery.validator;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import pl.jdbcqueryexample.jdbcquery.dto.ArtistCreateDTO;
import pl.jdbcqueryexample.jdbcquery.service.artist.crud.IArtistQueryService;

@AllArgsConstructor
@Component
public class ArtistValidator extends Validator {

    private final IArtistQueryService artistQueryService;

    public void validateCreate(ArtistCreateDTO dto , Errors errors) {
        validateStringEmpty("name" , dto.getName() , errors);
        validateStringEmpty("lastName" , dto.getLastName() , errors);
        validateStringEmpty("nickname" , dto.getNickname() , errors);
    }

    public void validateUpdate(Long id , Errors errors) {
        validateGetOptEntityExist(artistQueryService , id , errors);
    }
}

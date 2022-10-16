package pl.jdbcqueryexample.jdbcquery.validator;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import pl.jdbcqueryexample.jdbcquery.dto.SongCreateDTO;
import pl.jdbcqueryexample.jdbcquery.service.artist.crud.IArtistQueryService;

@AllArgsConstructor
@Component
public class SongValidator extends Validator {

    private final IArtistQueryService artistQueryService;

    public void validateCreate(SongCreateDTO dto , Errors errors) {
        validateStringEmpty("name" , dto.getName() , errors);
        validateObjectNonNull("artistId" , dto.getArtistId() , errors);

        if ( errors.hasErrors() ) {
            return;
        }

        validateGetOptEntityExist("artistId" , artistQueryService , dto.getArtistId() , errors);
    }


}

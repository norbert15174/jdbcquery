package pl.jdbcqueryexample.jdbcquery.service.artist;

import org.springframework.transaction.annotation.Transactional;
import pl.jdbcqueryexample.jdbcquery.dto.ArtistBasicDTO;
import pl.jdbcqueryexample.jdbcquery.dto.ArtistCreateDTO;

public interface IArtistService {
    @Transactional
    ArtistBasicDTO create(ArtistCreateDTO createDTO);
}

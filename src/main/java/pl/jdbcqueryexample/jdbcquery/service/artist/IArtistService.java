package pl.jdbcqueryexample.jdbcquery.service.artist;

import org.springframework.transaction.annotation.Transactional;
import pl.jdbcqueryexample.jdbcquery.dto.ArtistBasicDTO;
import pl.jdbcqueryexample.jdbcquery.dto.ArtistCreateDTO;
import pl.jdbcqueryexample.jdbcquery.dto.ArtistUpdateDTO;

import java.util.Set;

public interface IArtistService {

    ArtistBasicDTO create(ArtistCreateDTO createDTO);

    ArtistBasicDTO update(ArtistUpdateDTO createDTO, Long id);

    Set <ArtistBasicDTO> getAllBasicArtistDTO();

    ArtistBasicDTO getBasicArtistDTOById(Long id);

    void deleteById(Long id);
}

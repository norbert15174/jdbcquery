package pl.jdbcqueryexample.jdbcquery.service.artist;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.jdbcqueryexample.jdbcquery.creator.ArtistCreator;
import pl.jdbcqueryexample.jdbcquery.dto.ArtistBasicDTO;
import pl.jdbcqueryexample.jdbcquery.dto.ArtistCreateDTO;
import pl.jdbcqueryexample.jdbcquery.service.artist.crud.IArtistCudService;

@AllArgsConstructor
@Service
class ArtistService implements IArtistService {

    private final IArtistCudService artistCudService;

    @Transactional
    @Override
    public ArtistBasicDTO create(ArtistCreateDTO createDTO) {
        var created = artistCudService.create(createDTO);
        return ArtistCreator.artistBasicDTOByArtist(created);
    }

}

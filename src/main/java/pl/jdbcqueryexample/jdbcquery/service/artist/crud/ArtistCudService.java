package pl.jdbcqueryexample.jdbcquery.service.artist.crud;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.jdbcqueryexample.jdbcquery.creator.ArtistCreator;
import pl.jdbcqueryexample.jdbcquery.dto.ArtistCreateDTO;
import pl.jdbcqueryexample.jdbcquery.model.Artist;
import pl.jdbcqueryexample.jdbcquery.repository.IArtistRepository;

@Transactional
@AllArgsConstructor
@Service
class ArtistCudService implements IArtistCudService {

    private final IArtistRepository repository;

    @Override
    public Artist create(ArtistCreateDTO dto) {
        return repository.save(ArtistCreator.artistByArtistCreateDTO(dto));
    }

}

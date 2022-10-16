package pl.jdbcqueryexample.jdbcquery.service.artist.crud;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.jdbcqueryexample.jdbcquery.model.Artist;
import pl.jdbcqueryexample.jdbcquery.repository.IArtistRepository;

@Transactional
@AllArgsConstructor
@Service
class ArtistCudService implements IArtistCudService {

    private final IArtistRepository repository;

    @Override
    public Artist create(Artist entity) {
        return repository.save(entity);
    }

    @Override
    public Artist update(Artist entity) {
        return repository.update(entity);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}

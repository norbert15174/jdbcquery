package pl.jdbcqueryexample.jdbcquery.service.artist.crud;

import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.jdbcqueryexample.jdbcquery.exception.EntityNotFoundException;
import pl.jdbcqueryexample.jdbcquery.model.Artist;
import pl.jdbcqueryexample.jdbcquery.repository.IArtistRepository;

import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
class ArtistQueryService implements IArtistQueryService {

    private final IArtistRepository repository;

    @Override
    public Optional <Artist> getByIdOpt(Long id) {
        return Optional.ofNullable(repository.findById(id));
    }

    @Override
    public Optional <Artist> getWithSongsOpt(Long id) {
        return Optional.ofNullable(repository.findWithSongsById(id));
    }

    @Override
    public Artist getById(Long id) {
        return getByIdOpt(id).orElseThrow(() -> new EntityNotFoundException(String.format("Artist id : %d does not exist" , id)));
    }

    @Override
    public Set <Artist> getAll() {
        return repository.findAll();
    }

}

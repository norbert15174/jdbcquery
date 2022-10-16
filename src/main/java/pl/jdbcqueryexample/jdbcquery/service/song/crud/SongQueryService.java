package pl.jdbcqueryexample.jdbcquery.service.song.crud;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.jdbcqueryexample.jdbcquery.model.Song;
import pl.jdbcqueryexample.jdbcquery.repository.ISongRepository;

import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@Service
class SongQueryService implements ISongQueryService {

    private final ISongRepository repository;

    @Override
    public Optional <Song> getByIdOpt(Long id) {
        return Optional.ofNullable(repository.findById(id));
    }

    @Override
    public Set <Song> getAll() {
        return repository.findAll();
    }

}

package pl.jdbcqueryexample.jdbcquery.service.song.crud;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.jdbcqueryexample.jdbcquery.model.Song;
import pl.jdbcqueryexample.jdbcquery.repository.ISongRepository;

@Transactional
@AllArgsConstructor
@Service
class SongCudService implements ISongCudService {

    private final ISongRepository repository;

    @Override
    public Song create(Song entity) {
        return repository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}

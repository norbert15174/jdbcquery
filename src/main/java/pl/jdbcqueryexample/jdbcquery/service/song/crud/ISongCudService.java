package pl.jdbcqueryexample.jdbcquery.service.song.crud;

import pl.jdbcqueryexample.jdbcquery.model.Song;

public interface ISongCudService {
    Song create(Song entity);

    void deleteById(Long id);
}

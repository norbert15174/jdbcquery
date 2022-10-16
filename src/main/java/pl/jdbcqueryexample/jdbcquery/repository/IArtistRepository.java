package pl.jdbcqueryexample.jdbcquery.repository;

import pl.jdbcqueryexample.jdbcquery.model.Artist;
import pl.jdbcqueryexample.jdbcquery.repository.base.ICrudRepository;

public interface IArtistRepository extends ICrudRepository <Artist, Long> {
    Artist findWithSongsById(Long id);
}

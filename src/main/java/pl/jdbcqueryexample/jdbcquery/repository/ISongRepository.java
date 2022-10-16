package pl.jdbcqueryexample.jdbcquery.repository;

import org.springframework.stereotype.Repository;
import pl.jdbcqueryexample.jdbcquery.model.Song;
import pl.jdbcqueryexample.jdbcquery.repository.base.ICrudRepository;

@Repository
public interface ISongRepository extends ICrudRepository <Song, Long> {
}

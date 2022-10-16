package pl.jdbcqueryexample.jdbcquery.repository;

import org.springframework.stereotype.Repository;
import pl.jdbcqueryexample.jdbcquery.model.Song;

@Repository
public interface ISongRepository extends ICrudRepository <Song, Long> {
}

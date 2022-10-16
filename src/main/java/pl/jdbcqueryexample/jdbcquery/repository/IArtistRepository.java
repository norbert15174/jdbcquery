package pl.jdbcqueryexample.jdbcquery.repository;

import org.springframework.stereotype.Repository;
import pl.jdbcqueryexample.jdbcquery.model.Artist;

@Repository
public interface IArtistRepository extends ICrudRepository <Artist, Long> {
}

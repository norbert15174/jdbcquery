package pl.jdbcqueryexample.jdbcquery.service.artist.crud;

import pl.jdbcqueryexample.jdbcquery.model.Artist;
import pl.jdbcqueryexample.jdbcquery.repository.IGetOpt;

import java.util.Set;

public interface IArtistQueryService extends IGetOpt <Artist, Long> {
    Artist getById(Long id);

    Set <Artist> getAll();
}

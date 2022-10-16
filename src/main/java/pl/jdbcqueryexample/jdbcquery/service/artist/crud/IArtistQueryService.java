package pl.jdbcqueryexample.jdbcquery.service.artist.crud;

import pl.jdbcqueryexample.jdbcquery.model.Artist;
import pl.jdbcqueryexample.jdbcquery.repository.base.IGetOpt;

import java.util.Optional;
import java.util.Set;

public interface IArtistQueryService extends IGetOpt <Artist, Long> {
    Optional <Artist> getWithSongsOpt(Long id);

    Artist getById(Long id);

    Set <Artist> getAll();
}

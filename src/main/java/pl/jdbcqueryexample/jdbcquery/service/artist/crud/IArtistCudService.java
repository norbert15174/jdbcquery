package pl.jdbcqueryexample.jdbcquery.service.artist.crud;

import pl.jdbcqueryexample.jdbcquery.model.Artist;

public interface IArtistCudService {
    Artist create(Artist entity);

    Artist update(Artist entity);

    void deleteById(Long id);
}

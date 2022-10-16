package pl.jdbcqueryexample.jdbcquery.service.artist.crud;

import pl.jdbcqueryexample.jdbcquery.dto.ArtistCreateDTO;
import pl.jdbcqueryexample.jdbcquery.model.Artist;

public interface IArtistCudService {
    Artist create(ArtistCreateDTO dto);
}

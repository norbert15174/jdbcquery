package pl.jdbcqueryexample.jdbcquery.service.song.crud;

import pl.jdbcqueryexample.jdbcquery.model.Song;
import pl.jdbcqueryexample.jdbcquery.repository.base.IGetOpt;

import java.util.Set;

public interface ISongQueryService extends IGetOpt <Song, Long> {
    Set <Song> getAll();
}

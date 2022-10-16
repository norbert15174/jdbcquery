package pl.jdbcqueryexample.jdbcquery.repository;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.jdbcqueryexample.jdbcquery.exception.SQLModifyException;
import pl.jdbcqueryexample.jdbcquery.model.Song;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
@Repository
class SongRepositoryImpl implements ISongRepository, RowMapper <Song> {

    private final JdbcTemplate jdbcTemplate;

    @Transactional
    @Override
    public Song save(Song entity) {
        String sql = String.format("INSERT INTO song (name, artist_id) VALUES(%s,%s)" , entity.getName() , entity.getArtist().getId());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> connection.prepareStatement(sql ,
                Statement.RETURN_GENERATED_KEYS) , keyHolder);
        if ( Objects.isNull(keyHolder.getKey()) ) {
            throw new SQLModifyException("Cannot create Song: " + entity.getName());
        }
        return findById(keyHolder.getKey().longValue());
    }

    @Transactional
    @Override
    public Song update(Song update) {
        return null;
    }

    @Transactional
    @Override
    public void deleteById(Long id) {

    }

    @Transactional(readOnly = true)
    @Override
    public Song findById(Long id) {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public Set <Song> findAll() {
        return null;
    }

    @Override
    public Song mapRow(ResultSet rs , int rowNum) throws SQLException {
        return null;
    }

}

package pl.jdbcqueryexample.jdbcquery.repository;

import lombok.AllArgsConstructor;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.jdbcqueryexample.jdbcquery.exception.SQLModifyException;
import pl.jdbcqueryexample.jdbcquery.model.Artist;
import pl.jdbcqueryexample.jdbcquery.model.Song;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
@Repository
class SongRepositoryImpl implements ISongRepository, RowMapper <Song> {

    private final JdbcTemplate jdbcTemplate;

    @Transactional
    @Override
    public Song save(Song entity) {
        String sql = String.format("INSERT INTO song (name, artist_id) VALUES('%s',%d)" , entity.getName() , entity.getArtist().getId());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> connection.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS) , keyHolder);
        if ( Objects.isNull(keyHolder.getKey()) ) {
            throw new SQLModifyException("Cannot create Song: " + entity.getName());
        }
        return findById(keyHolder.getKey().longValue());
    }

    @Transactional
    @Override
    public Song update(Song entity) {
        String sql = String.format("UPDATE song SET name='%s' WHERE id=%d" , entity.getName(), entity.getId());
        jdbcTemplate.update(sql);
        return findById(entity.getId());
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        String sql = "DELETE FROM song WHERE id = ?";
        jdbcTemplate.update(sql , id);
    }

    @Transactional(readOnly = true)
    @Override
    public Song findById(Long id) {
        String sql = "SELECT * FROM song s INNER JOIN artist a ON s.artist_id = a.id WHERE s.id = ?";
        List <Song> songs = jdbcTemplate.query(sql , this , id);
        switch (songs.size()) {
            case 0:
                return null;
            case 1:
                return songs.get(0);
            default:
                throw new IncorrectResultSizeDataAccessException(songs.size());
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Set <Song> findAll() {
        String sql = "SELECT * FROM song s INNER JOIN artist a ON s.artist_id = a.id";
        List <Song> songs = jdbcTemplate.query(sql , this);
        return new HashSet <>(songs);
    }

    @Override
    public Song mapRow(ResultSet rs , int rowNum) throws SQLException {
        return Song.builder()
                .id(rs.getLong("s.id"))
                .name(rs.getString("s.name"))
                .artist(Artist.builder()
                        .id(rs.getLong("a.id"))
                        .name(rs.getString("a.name"))
                        .lastName(rs.getString("a.last_name"))
                        .nickname(rs.getString("a.nickname"))
                        .build()
                )
                .build();
    }

}

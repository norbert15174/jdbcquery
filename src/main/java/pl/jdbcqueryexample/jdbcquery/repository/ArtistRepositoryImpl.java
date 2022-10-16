package pl.jdbcqueryexample.jdbcquery.repository;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.jdbcqueryexample.jdbcquery.exception.SQLModifyException;
import pl.jdbcqueryexample.jdbcquery.model.Artist;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
@Repository
class ArtistRepositoryImpl implements IArtistRepository, RowMapper <Artist> {

    private final JdbcTemplate jdbcTemplate;

    @Transactional
    @Override
    public Artist save(Artist entity) {
        String sql = String.format("INSERT INTO artist (name, last_name, nickname) VALUES('%s','%s','%s')" , entity.getName() , entity.getLastName() , entity.getNickname());
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
    public Artist update(Artist update) {
        return null;
    }

    @Transactional
    @Override
    public void deleteById(Long id) {

    }

    @Transactional
    @Override
    public void delete(Artist entity) {

    }

    @Transactional(readOnly = true)
    @Override
    public Artist findById(Long id) {
        String sql = "SELECT * FROM artist WHERE id = ?";
        return jdbcTemplate.queryForObject(sql , this , id);
    }

    @Transactional(readOnly = true)
    @Override
    public Set <Artist> finalAll() {
        return null;
    }

    @Override
    public Artist mapRow(ResultSet rs , int rowNum) throws SQLException {
        return Artist.builder()
                .id(rs.getLong("id"))
                .name(rs.getString("name"))
                .lastName(rs.getString("last_name"))
                .nickname(rs.getString("nickname"))
                .build();
    }
}

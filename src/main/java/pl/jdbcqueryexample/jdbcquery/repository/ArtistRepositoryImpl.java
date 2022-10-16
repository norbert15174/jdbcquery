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

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.List;
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
    public Artist update(Artist entity) {
        String sql = String.format("UPDATE artist SET name='%s', last_name='%s', nickname='%s' WHERE id=%d" , entity.getName() , entity.getLastName() , entity.getNickname() , entity.getId());
        jdbcTemplate.update(sql);
        return findById(entity.getId());
    }


    @Transactional(readOnly = true)
    @Override
    public Artist findById(Long id) {
        String sql = "SELECT * FROM artist WHERE id = ?";
        List <Artist> artist = jdbcTemplate.query(sql , this , id);
        switch (artist.size()) {
            case 0:
                return null;
            case 1:
                return artist.get(0);
            default:
                throw new IncorrectResultSizeDataAccessException(artist.size());
        }
    }


    @Transactional(readOnly = true)
    @Override
    public Set <Artist> findAll() {
        String sql = "SELECT * FROM artist";
        List <Artist> artists = jdbcTemplate.query(sql , this);
        return new HashSet <>(artists);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        String sql = "DELETE FROM artist WHERE id = ?";
        jdbcTemplate.update(sql , id);
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

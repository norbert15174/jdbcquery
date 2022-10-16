package pl.jdbcqueryexample.jdbcquery.service.song;

import pl.jdbcqueryexample.jdbcquery.dto.SongCreateDTO;
import pl.jdbcqueryexample.jdbcquery.dto.SongDTO;

import java.util.List;

public interface ISongService {
    SongDTO create(SongCreateDTO dto);

    void deleteById(Long id);

    SongDTO getSongDTOById(Long id);

    List <SongDTO> getAllSongDTO();
}

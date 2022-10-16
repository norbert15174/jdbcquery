package pl.jdbcqueryexample.jdbcquery.service.song;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.jdbcqueryexample.jdbcquery.creator.SongCreator;
import pl.jdbcqueryexample.jdbcquery.dto.SongCreateDTO;
import pl.jdbcqueryexample.jdbcquery.dto.SongDTO;
import pl.jdbcqueryexample.jdbcquery.exception.EntityNotFoundException;
import pl.jdbcqueryexample.jdbcquery.service.artist.crud.IArtistQueryService;
import pl.jdbcqueryexample.jdbcquery.service.song.crud.ISongCudService;
import pl.jdbcqueryexample.jdbcquery.service.song.crud.ISongQueryService;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
class SongService implements ISongService {

    private final ISongQueryService songQueryService;
    private final ISongCudService songCudService;
    private final IArtistQueryService artistQueryService;

    @Override
    @Transactional
    public SongDTO create(SongCreateDTO dto) {
        var artist = artistQueryService.getById(dto.getArtistId());
        var created = songCudService.create(SongCreator.songBySongCreateDTOAndArtist(dto , artist));
        return SongCreator.songDTOBySong(created);
    }

    @Override
    public void deleteById(Long id) {
        songQueryService.getByIdOpt(id).orElseThrow(() -> new EntityNotFoundException(String.format("Song id %d does not exist" , id)));
        songCudService.deleteById(id);
    }

    @Override
    public SongDTO getSongDTOById(Long id) {
        var song = songQueryService.getByIdOpt(id).orElseThrow(() -> new EntityNotFoundException(String.format("Song id %d does not exist" , id)));
        return SongCreator.songDTOBySong(song);
    }

    @Override
    public List <SongDTO> getAllSongDTO() {
        var song = songQueryService.getAll();
        return song.stream().map(SongCreator::songDTOBySong).collect(Collectors.toList());
    }

}

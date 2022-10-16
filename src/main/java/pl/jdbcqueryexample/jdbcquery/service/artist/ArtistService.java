package pl.jdbcqueryexample.jdbcquery.service.artist;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.jdbcqueryexample.jdbcquery.creator.ArtistCreator;
import pl.jdbcqueryexample.jdbcquery.dto.ArtistBasicDTO;
import pl.jdbcqueryexample.jdbcquery.dto.ArtistCreateDTO;
import pl.jdbcqueryexample.jdbcquery.dto.ArtistDTO;
import pl.jdbcqueryexample.jdbcquery.dto.ArtistUpdateDTO;
import pl.jdbcqueryexample.jdbcquery.exception.EntityNotFoundException;
import pl.jdbcqueryexample.jdbcquery.service.artist.crud.IArtistCudService;
import pl.jdbcqueryexample.jdbcquery.service.artist.crud.IArtistQueryService;
import pl.jdbcqueryexample.jdbcquery.service.song.crud.ISongCudService;

import java.util.Set;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
@AllArgsConstructor
@Service
class ArtistService implements IArtistService {

    private final IArtistCudService artistCudService;
    private final IArtistQueryService artistQueryService;
    private final ISongCudService songCudService;

    @Transactional
    @Override
    public ArtistBasicDTO create(ArtistCreateDTO dto) {
        var created = artistCudService.create(ArtistCreator.artistByArtistCreateDTO(dto));
        return ArtistCreator.artistBasicDTOByArtist(created);
    }

    @Transactional
    @Override
    public ArtistBasicDTO update(ArtistUpdateDTO dto , Long id) {
        var entity = artistQueryService.getById(id);
        var updated = artistCudService.update(ArtistCreator.artistByArtistUpdateDTO(dto , entity));
        return ArtistCreator.artistBasicDTOByArtist(updated);
    }

    @Override
    public Set <ArtistBasicDTO> getAllBasicArtistDTO() {
        return artistQueryService.getAll().stream().map(ArtistCreator::artistBasicDTOByArtist).collect(Collectors.toSet());
    }

    @Override
    public ArtistDTO getArtistDTOById(Long id) {
        var artist = artistQueryService.getWithSongsOpt(id).orElseThrow(() -> new EntityNotFoundException(String.format("Artist id %d does not exist" , id)));
        return ArtistCreator.artistDTOByArtist(artist);
    }

    @Override
    public ArtistBasicDTO getBasicArtistDTOById(Long id) {
        var byId = artistQueryService.getByIdOpt(id).orElseThrow(() -> new EntityNotFoundException(String.format("Artist id %d does not exist" , id)));
        return ArtistCreator.artistBasicDTOByArtist(byId);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        var byId = artistQueryService.getWithSongsOpt(id).orElseThrow(() -> new EntityNotFoundException(String.format("Artist id %d does not exist" , id)));
        for (var song : byId.getSongs()) {
            songCudService.deleteById(song.getId());
        }
        artistCudService.deleteById(id);
    }

}

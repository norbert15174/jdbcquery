package pl.jdbcqueryexample.jdbcquery.creator;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.jdbcqueryexample.jdbcquery.dto.SongBasicDTO;
import pl.jdbcqueryexample.jdbcquery.dto.SongCreateDTO;
import pl.jdbcqueryexample.jdbcquery.dto.SongDTO;
import pl.jdbcqueryexample.jdbcquery.model.Artist;
import pl.jdbcqueryexample.jdbcquery.model.Song;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SongCreator {

    public static Song songBySongCreateDTOAndArtist(SongCreateDTO dto , Artist entity) {
        return Song.builder()
                .name(dto.getName())
                .artist(entity)
                .build();
    }

    public static SongBasicDTO songBasicDtoBySong(Song entity) {
        return SongBasicDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    public static SongDTO songDTOBySong(Song entity) {
        return SongDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .artist(ArtistCreator.artistBasicDTOByArtist(entity.getArtist()))
                .build();
    }

}

package pl.jdbcqueryexample.jdbcquery.creator;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.jdbcqueryexample.jdbcquery.dto.*;
import pl.jdbcqueryexample.jdbcquery.model.Artist;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ArtistCreator {

    public static Artist artistByArtistCreateDTO(ArtistCreateDTO dto) {
        return Artist.builder()
                .name(dto.getName())
                .lastName(dto.getLastName())
                .nickname(dto.getNickname())
                .build();
    }

    public static ArtistBasicDTO artistBasicDTOByArtist(Artist entity) {
        return ArtistBasicDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .lastName(entity.getLastName())
                .nickname(entity.getNickname())
                .build();
    }

    public static ArtistDTO artistDTOByArtist(Artist entity) {
        List <SongBasicDTO> songs = new ArrayList <>();
        for (var song : entity.getSongs()) {
            songs.add(SongCreator.songBasicDtoBySong(song));
        }

        return ArtistDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .lastName(entity.getLastName())
                .nickname(entity.getNickname())
                .songs(songs)
                .build();
    }

    public static Artist artistByArtistUpdateDTO(ArtistUpdateDTO dto , Artist entity) {

        if ( dto.hasName() ) {
            entity.setName(dto.getName());
        }

        if ( dto.hasLastName() ) {
            entity.setLastName(dto.getLastName());
        }

        if ( dto.hasNickName() ) {
            entity.setNickname(dto.getNickname());
        }

        return entity;
    }
}

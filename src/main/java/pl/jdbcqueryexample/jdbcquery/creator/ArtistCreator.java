package pl.jdbcqueryexample.jdbcquery.creator;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.jdbcqueryexample.jdbcquery.dto.ArtistBasicDTO;
import pl.jdbcqueryexample.jdbcquery.dto.ArtistCreateDTO;
import pl.jdbcqueryexample.jdbcquery.dto.ArtistUpdateDTO;
import pl.jdbcqueryexample.jdbcquery.model.Artist;

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

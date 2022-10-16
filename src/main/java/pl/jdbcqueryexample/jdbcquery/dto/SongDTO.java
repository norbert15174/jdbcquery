package pl.jdbcqueryexample.jdbcquery.dto;

import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Builder
public class SongDTO {

    private Long id;
    private String name;
    private ArtistBasicDTO artist;

}

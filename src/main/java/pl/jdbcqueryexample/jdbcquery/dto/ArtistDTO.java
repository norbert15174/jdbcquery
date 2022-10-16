package pl.jdbcqueryexample.jdbcquery.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ArtistDTO {

    private Long id;
    private String name;
    private String lastName;
    private String nickname;
    private List <SongBasicDTO> songs;

}

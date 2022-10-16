package pl.jdbcqueryexample.jdbcquery.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ArtistBasicDTO {

    private Long id;
    private String name;
    private String lastName;
    private String nickname;

}

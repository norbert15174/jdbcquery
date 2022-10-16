package pl.jdbcqueryexample.jdbcquery.dto;

import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Builder
public class SongBasicDTO {

    private Long id;
    private String name;

}

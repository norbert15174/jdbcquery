package pl.jdbcqueryexample.jdbcquery.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class SongCreateDTO {

    private String name;
    private Long artistId;

}

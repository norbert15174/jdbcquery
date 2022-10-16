package pl.jdbcqueryexample.jdbcquery.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ArtistUpdateDTO {

    private String name;
    private String lastName;
    private String nickname;

}

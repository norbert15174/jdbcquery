package pl.jdbcqueryexample.jdbcquery.model;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Artist {

    private Long id;
    private String name;
    private String lastName;
    private String nickname;

    public Set <Song> songs = new HashSet <>();

}

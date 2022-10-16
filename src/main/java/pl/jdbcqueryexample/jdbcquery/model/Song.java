package pl.jdbcqueryexample.jdbcquery.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Song {

    private Long id;
    private String name;
    private Artist artist;

}

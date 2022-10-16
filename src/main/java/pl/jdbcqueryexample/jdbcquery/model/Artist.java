package pl.jdbcqueryexample.jdbcquery.model;

import lombok.*;

import java.util.HashSet;
import java.util.Objects;
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

    public void addSong(Song song) {
        song.setArtist(this);
        this.songs.add(song);
    }

    @Override
    public boolean equals(Object o) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;
        Artist artist = (Artist) o;
        return id != null && Objects.equals(id , artist.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

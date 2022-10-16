package pl.jdbcqueryexample.jdbcquery.dto;

import com.google.common.base.Strings;
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

    public boolean hasName() {
        return !Strings.isNullOrEmpty(name);
    }

    public boolean hasLastName() {
        return !Strings.isNullOrEmpty(lastName);
    }

    public boolean hasNickName() {
        return !Strings.isNullOrEmpty(nickname);
    }

}

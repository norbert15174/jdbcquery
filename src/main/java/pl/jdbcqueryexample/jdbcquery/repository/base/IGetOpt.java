package pl.jdbcqueryexample.jdbcquery.repository.base;

import java.util.Optional;

public interface IGetOpt <T, ID> {

    Optional <T> getByIdOpt(ID id);

}

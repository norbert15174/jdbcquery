package pl.jdbcqueryexample.jdbcquery.repository;

import java.util.Optional;

public interface IGetOpt <T, ID> {

    Optional <T> getByIdOpt(ID id);

}

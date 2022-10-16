package pl.jdbcqueryexample.jdbcquery.repository;

import java.util.Set;

public interface ICrudRepository<T, ID> {

    T save(T entity);

    T update(T update);

    void deleteById(ID id);

    T findById(ID id);

    Set <T> findAll();

}

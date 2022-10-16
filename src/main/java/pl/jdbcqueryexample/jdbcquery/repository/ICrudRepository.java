package pl.jdbcqueryexample.jdbcquery.repository;

import java.util.Set;

public interface ICrudRepository<T, K> {

    T save(T entity);

    T update(T update);

    void deleteById(K id);

    void delete(T entity);

    T findById(K id);

    Set <T> finalAll();

}

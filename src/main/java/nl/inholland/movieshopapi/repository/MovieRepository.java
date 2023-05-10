package nl.inholland.movieshopapi.repository;

import nl.inholland.movieshopapi.model.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MovieRepository extends CrudRepository<Movie, Long> {
//    This saves a T the that database, or a subtype thereof
    @Override
    <S extends Movie> S save(S entity);

    @Override
    <S extends Movie> Iterable<S> saveAll(Iterable<S> entities);

    @Override
    Optional<Movie> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    /*  Creates a collection of all objects in the database of that type. This
    collection can be iterated over, and is sometimes cast as List<T>   */
    @Override
    Iterable<Movie> findAll();

    @Override
    Iterable<Movie> findAllById(Iterable<Long> longs);

//    Deletes the object with the given id from the database
    @Override
    void deleteById(Long aLong);

    @Override
    void delete(Movie entity);

    @Override
    void deleteAllById(Iterable<? extends Long> longs);

    @Override
    void deleteAll(Iterable<? extends Movie> entities);

    @Override
    void deleteAll();
}

package nl.inholland.movieshopapi.service;

import nl.inholland.movieshopapi.model.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    private List<Movie> movieList = new ArrayList<>();

    public MovieService(List<Movie> movieList) {
        this.movieList = movieList;
    }

    public Movie addMovie(Movie movie) {
        movieList.add(movie);
        return movie;
    }

    public void updateMovie(Movie movie) {
        for (int i = 0; i < movieList.size(); i++) {
            Movie m = movieList.get(i);
            if (m.getId() == movie.getId()) {
                movieList.set(i, movie);
                return;
            }
        }
        throw new IllegalArgumentException("Movie not present");
    }

    public void deleteMovie(Movie movie) {
        if (!movieList.remove(movie)) {
            throw new IllegalArgumentException("Movie not present");
        }
    }

    public List<Movie> getAllMovies() {
        if (movieList.isEmpty()) {
            throw new IllegalStateException("Movie list is empty");
        }
        return movieList;
    }

    public Movie getMovieById(long id) {
        for (Movie movie : movieList) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        throw new IllegalArgumentException("Movie not present");
    }
}

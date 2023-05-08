package nl.inholland.movieshopapi.controller;

import nl.inholland.movieshopapi.model.Movie;
import nl.inholland.movieshopapi.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        try {
            return ResponseEntity.ok(movieService.getAllMovies());
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable long id) {
        try {
            return ResponseEntity.ok(movieService.getMovieById(id));
        } catch (Exception e) {
            return  ResponseEntity.status(500).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        try {
            return ResponseEntity.ok(movieService.addMovie(movie));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @PutMapping
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie) {
        try {
             movieService.updateMovie(movie);
             return ResponseEntity.status(204).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @DeleteMapping
    public ResponseEntity<Movie> deleteMovie(@RequestBody Movie movie) {
        try {
            movieService.deleteMovie(movie);
            return ResponseEntity.status(204).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

}

package nl.inholland.movieshopapi;

import nl.inholland.movieshopapi.model.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MovieTest {
//    Assertions are used in unit testing to validate the expected behavior of a piece of code
    Movie movie = new Movie();
    @Test
    void createNewMovieShouldResultInValidObject() {
//        Movie movie = new Movie();
        Assertions.assertNotNull(movie);
    }

    // had to add an if statement to Price setter in model class to make this test pass
    @Test
    void setMoviePriceToNegativeShouldResultInIllegalArgumentException() {
        //capture assert throwing messages and the exception
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            movie.setPrice(-1);
        });
        Assertions.assertEquals("Price cannot be negative", exception.getMessage());
    }

    @Test
    void MoviesShouldHave1Title() {
        movie.setTitle("The Matrix");
        Assertions.assertEquals("The Matrix", movie.getTitle());
    }
}

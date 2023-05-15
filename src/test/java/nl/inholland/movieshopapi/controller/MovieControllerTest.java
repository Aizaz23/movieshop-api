package nl.inholland.movieshopapi.controller;

import nl.inholland.movieshopapi.model.Movie;
import nl.inholland.movieshopapi.service.MovieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@ExtendWith(SpringExtension.class)
@WebMvcTest(MovieController.class)
@AutoConfigureMockMvc
class MovieControllerTest {

    private nl.inholland.movieshopapi.model.Movie movie;

    @BeforeEach
    void init() {
        movie = new Movie();
        movie.setId(1);
    }

    @Autowired
//    private MockMvc mockMvc;

    @MockBean
    private MovieService movieService;

//    @Test
//    void getAllMoviesShouldReturnAListOfOne() throws Exception {
//        when(movieService.getAllMovies())
//                .thenReturn(List.of(movie));
//
//        this.mockMvc.perform(MockMvcRequestBuilders.get("/movies"))
//                .andDo(print())
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(jsonPath(("$[0].name").value("The Matrix")));
//    }
//
//    @Test
//    void createMovieShouldReturnObjectAndStatus201() throws Exception {
//        when(movieService.addMovie(any(Movie.class)))
//                .thenReturn(movie);
//        this.mockMvc.perform(
//                MockMvcRequestBuilders.post("/movies")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("{}"))
//                .andExpect(status.isCreated())
//                .andExpect(jsonPath("$.id").value(1));
//
//
//    }
}

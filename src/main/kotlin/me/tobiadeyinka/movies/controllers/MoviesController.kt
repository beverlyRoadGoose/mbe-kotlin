package me.tobiadeyinka.movies.controllers

import me.tobiadeyinka.movies.entities.Movie
import me.tobiadeyinka.movies.entities.Trailer
import me.tobiadeyinka.movies.modules.MoviesManager

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import org.springframework.beans.factory.annotation.Autowired


@RestController
@RequestMapping(value = ["/movies"], produces = [MediaType.APPLICATION_JSON_VALUE])
class MoviesController {

    @Autowired private val moviesManager: MoviesManager? = null

    @GetMapping("/top")
    @ResponseBody
    fun getTopMovies(): List<Movie>? = moviesManager?.getTopMovies()

    @GetMapping("/top/{page}")
    @ResponseBody
    fun getTopMovies(@PathVariable page: Int): List<Movie>? = moviesManager?.getTopMovies(page)

    @GetMapping("/popular")
    @ResponseBody
    fun getPopularMovies(): List<Movie>? = moviesManager?.getPopularMovies()

    @GetMapping("/{movieId}/trailer")
    @ResponseBody
    fun getMovieTrailer(@PathVariable movieId: Int): Trailer? = moviesManager?.getMovieTrailer(movieId)

    @GetMapping("/{movieId}")
    @ResponseBody
    fun getMovie(@PathVariable movieId: Int): Movie? = moviesManager?.getMovie(movieId)

    @GetMapping("/popular/{page}")
    @ResponseBody
    fun getPopularMovies(@PathVariable page: Int): List<Movie>? = moviesManager?.getPopularMovies(page)

}
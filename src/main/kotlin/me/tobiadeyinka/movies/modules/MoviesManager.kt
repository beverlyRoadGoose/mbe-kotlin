package me.tobiadeyinka.movies.modules

import me.tobiadeyinka.movies.entities.Movie
import me.tobiadeyinka.movies.entities.Trailer
import me.tobiadeyinka.movies.networking.MovieQueries

import org.json.JSONObject
import org.springframework.stereotype.Component

import java.util.ArrayList

@Component
class MoviesManager {

    fun getTopMovies(): List<Movie> = extractMoviesFromJsonString(MovieQueries.getTopRatedMovies(1))

    fun getTopMovies(page: Int): List<Movie> = extractMoviesFromJsonString(MovieQueries.getTopRatedMovies(page))

    fun getPopularMovies(): List<Movie> = extractMoviesFromJsonString(MovieQueries.getPopularMovies(1))

    fun getPopularMovies(page: Int): List<Movie> = extractMoviesFromJsonString(MovieQueries.getPopularMovies(page))

    fun getMovie(movieId: Int): Movie {
        val movie = JSONObject(MovieQueries.getMovieDetails(movieId))
        return Movie(
            movieId,
            movie.getString("title"),
            movie.getString("release_date"),
            movie.getString("poster_path"),
            movie.getString("overview")
        )
    }

    fun getMovieTrailer(movieId: Int): Trailer? {
        val jsonObject = JSONObject(MovieQueries.getMovieVideos(movieId))
        val results = jsonObject.getJSONArray("results")
        val n = results.length()
        var videoJsonObject: JSONObject

        for (i in 0 until n) {
            videoJsonObject = results.getJSONObject(i)
            if (videoJsonObject.getString("type") == "Trailer" && videoJsonObject.getString("site") == "YouTube") {
                return Trailer(movieId, videoJsonObject.getString("key"))
            }
        }

        return null
    }

    private fun extractMoviesFromJsonString(jsonString: String): List<Movie> {
        val movies = ArrayList<Movie>()

        val jsonObject = JSONObject(jsonString)
        val results = jsonObject.getJSONArray("results")
        val n = results.length()
        var movieJsonObject: JSONObject

        for (i in 0..n) {
            movieJsonObject = results.getJSONObject(i)
            val id = movieJsonObject.getInt("id")
            val title = movieJsonObject.getString("title")
            val releaseDate = movieJsonObject.getString("release_date")
            val moviePoster = movieJsonObject.getString("poster_path")
            val plotSynopsis = movieJsonObject.getString("overview")
            movies.add(Movie(id, title, releaseDate, moviePoster, plotSynopsis))
        }

        return movies
    }

}
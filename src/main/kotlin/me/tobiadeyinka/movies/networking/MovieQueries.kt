package me.tobiadeyinka.movies.networking

import java.net.URL

private const val BASE_URL: String = "https://api.themoviedb.org/3/movie/"
private val MOVIE_DB_API_KEY: String? = System.getenv("MOVIE_DB_API_KEY")
private val POPULAR_MOVIES_ENDPOINT = String.format("%spopular?api_key=%s&language=en-US&page=", BASE_URL, MOVIE_DB_API_KEY)
private val TOP_RATED_MOVIES_ENDPOINT = String.format("%stop_rated?api_key=%s&language=en-US&page=", BASE_URL, MOVIE_DB_API_KEY)

class MovieQueries {

    companion object {
        fun getPopularMovies(page: Int): String = URL(POPULAR_MOVIES_ENDPOINT + page).readText()

        fun getTopRatedMovies(page: Int): String = URL(TOP_RATED_MOVIES_ENDPOINT + page).readText()

        fun getMovieDetails(movieId: Int): String = URL(
            String.format("%s%s/videos?api_key=%s&language=en-US", BASE_URL, movieId, MOVIE_DB_API_KEY)
        ).readText()

        fun getMovieReviews(movieId: Int): String = URL(
            String.format("%s%s/reviews?api_key=%s&language=en-US&page=1", BASE_URL, movieId, MOVIE_DB_API_KEY)
        ).readText()
    }

}
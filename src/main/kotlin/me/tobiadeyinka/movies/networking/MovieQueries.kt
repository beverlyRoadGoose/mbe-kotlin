package me.tobiadeyinka.movies.networking

import java.net.URL

private val BASE_URL: String = "https://api.themoviedb.org/3/movie/"
private val MOVIE_DB_API_KEY: String? = System.getenv("MOVIE_DB_API_KEY")
val POPULAR_MOVIES_ENDPOINT = String.format("%spopular?api_key=%s&language=en-US&page=", BASE_URL, MOVIE_DB_API_KEY)
val TOP_RATED_MOVIES_ENDPOINT = String.format("%stop_rated?api_key=%s&language=en-US&page=", BASE_URL, MOVIE_DB_API_KEY)

class MovieQueries {
    
    companion object {
        @JvmStatic fun getPopularMovies(page: Int): String = URL(POPULAR_MOVIES_ENDPOINT).readText()
    }

}
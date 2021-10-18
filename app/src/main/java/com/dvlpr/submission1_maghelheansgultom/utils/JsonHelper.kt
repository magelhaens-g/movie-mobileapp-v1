package com.dvlpr.submission1_maghelheansgultom.utils

import android.content.Context
import com.dvlpr.submission1_maghelheansgultom.data.source.remote.response.MovieResponse
import com.dvlpr.submission1_maghelheansgultom.data.source.remote.response.TVShowResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {
    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadMovies(): List<MovieResponse> {
        val list = ArrayList<MovieResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("MovieResponses.json").toString())
            val listArray = responseObject.getJSONArray("movies")
            for (i in 0 until listArray.length()) {
                val movies = listArray.getJSONObject(i)

                val movieId = movies.getString("movieId")
                val title = movies.getString("title")
                val genre = movies.getString("genre")
                val rating = movies.getString("rating")
                val director = movies.getString("director")
                val desc = movies.getString("desc")
                val releaseDate = movies.getString("releaseDate")
                val favorite = movies.getBoolean("favorite")
                val imagePath = movies.getString("imagePath")

                val movieResponse = MovieResponse(movieId, title, genre, rating, director, desc, releaseDate,favorite, imagePath)
                list.add(movieResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }

    fun getMovieDetail(movieId : String): MovieResponse {
        var movie = MovieResponse("","","","","","","",false, "")
        try {
            val responseObject = JSONObject(parsingFileToString("MovieResponses.json").toString())
            val resultMovie = responseObject.getJSONObject(movieId)
            val movieId = resultMovie.getString("movieId")
            val title = resultMovie.getString("title")
            val genre = resultMovie.getString("genre")
            val rating = resultMovie.getString("rating")
            val director = resultMovie.getString("director")
            val desc = resultMovie.getString("desc")
            val releaseDate = resultMovie.getString("releaseDate")
            val favorite = resultMovie.getBoolean("favorite")
            val imagePath = resultMovie.getString("imagePath")

            val movieResponse = MovieResponse(movieId, title, genre, rating, director, desc, releaseDate,favorite, imagePath)
            movie = movieResponse
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return movie
    }

    fun loadTvShows(): List<TVShowResponse> {
        val list = ArrayList<TVShowResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("TvShowResponses.json").toString())
            val listArray = responseObject.getJSONArray("tvshows")
            for (i in 0 until listArray.length()) {
                val tvshows = listArray.getJSONObject(i)

                val tvShowsId = tvshows.getString("tvShowsId")
                val title = tvshows.getString("title")
                val genre = tvshows.getString("genre")
                val rating = tvshows.getString("rating")
                val creator = tvshows.getString("creator")
                val desc = tvshows.getString("desc")
                val status = tvshows.getString("status")
                val favorite = tvshows.getBoolean("favorite")
                val imagePath = tvshows.getString("imagePath")

                val tvShowResponse = TVShowResponse(tvShowsId, title, genre, rating, creator, desc, status,favorite, imagePath)
                list.add(tvShowResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }

    fun getTvShowDetail(tvShowId : String): TVShowResponse {
        var tvShow = TVShowResponse("","","","","","","",false, "")
        try {
            val responseObject = JSONObject(parsingFileToString("TvShowResponses.json").toString())
            val resultTvShow = responseObject.getJSONObject(tvShowId)
            val tvShowId = resultTvShow.getString("tvShowId")
            val title = resultTvShow.getString("title")
            val genre = resultTvShow.getString("genre")
            val rating = resultTvShow.getString("rating")
            val creator = resultTvShow.getString("creator")
            val desc = resultTvShow.getString("desc")
            val status = resultTvShow.getString("status")
            val favorite = resultTvShow.getBoolean("favorite")
            val imagePath = resultTvShow.getString("imagePath")

            val tvShowResponse = TVShowResponse(tvShowId, title, genre, rating, creator, desc, status,favorite, imagePath)
            tvShow = tvShowResponse
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return tvShow
    }
}
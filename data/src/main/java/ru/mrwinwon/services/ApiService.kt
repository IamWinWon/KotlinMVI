package ru.mrwinwon.services

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import ru.mrwinwon.domain.dto.MovieRemote
import ru.mrwinwon.domain.dto.Movies

/**
 * Created by Artem Winokurov on 12.04.2021.
 * MrWinWon
 * marriedmrsleep@gmail.com
 */
interface ApiService {

    @GET("/movies/all/page/{id}/token/{user_token}")
    suspend fun getMovies(
        @Path(value = "id", encoded = true) id: Int,
        @Path(value = "user_token", encoded = true) tail: String): Response<Movies>

    @GET("/movies/all")
    suspend fun getMovie(id: Int, tail: String): Response<MovieRemote>

    @GET("/tv-series/all")
    suspend fun getTVSeries(tail: String): Response<Movies>

}
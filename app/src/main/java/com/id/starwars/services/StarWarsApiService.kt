package com.id.starwars.services

import com.id.starwars.models.StarshipResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface StarWarsApiService {
    @GET("starships/")
    suspend fun getStarships(@Query("page") page: Int): Response<StarshipResponse>
}

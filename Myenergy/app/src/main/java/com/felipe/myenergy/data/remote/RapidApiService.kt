package com.felipe.myenergy.data.remote

import com.felipe.myenergy.domain.Car
import retrofit2.Response
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query


interface RapidApiService {

    @Headers("Content-Type: application/json")
    @POST("/routes/best_route")
    suspend fun bestRoute(
        @Query("origin") origin: String?,
        @Query("destination") destination: String?,
        @Query("vehicle") vehicle: String?
    ): Response <Car>
}

package com.felipe.myenergy.data

import com.felipe.myenergy.data.remote.RapidApiService
import com.felipe.myenergy.domain.Car
import kotlinx.coroutines.delay
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class Repository() {
    suspend fun getBestRoute(startDestination: String, endDestination: String): Response<Car> {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://rc3hxqcf-8002.use.devtunnels.ms")
            .build()

        val service = retrofit.create(RapidApiService::class.java)

        // remover este bloque cuando el profesor encienda la API
        delay(1000L)
        return Response.success(Car(
            startDestination, endDestination,"Calle 43 despues del centro"
        ))

        // Des comentar la linea de abajo para hacer la solicitud http
        //return service.bestRoute(startDestination, endDestination, "car")
    }
}

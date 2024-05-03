package com.felipe.myenergy.domain

import com.felipe.myenergy.data.Repository

class GetBestRouteUseCase(private val repository: Repository) {

    suspend operator fun invoke(startDestination: String, endDestination: String): Car {
        val response = repository.getBestRoute(startDestination, endDestination)
        return try {
            if(response.isSuccessful) {
                response.body()!!
            } else {
                badCarResponse()
            }
        }catch (e: Exception) {
            badCarResponse()
        }
    }

    private fun badCarResponse() = Car(
        "0", "0","There is an error getting the best route"
    )
}

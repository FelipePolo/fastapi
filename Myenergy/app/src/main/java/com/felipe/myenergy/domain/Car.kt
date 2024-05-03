package com.felipe.myenergy.domain

import com.google.gson.annotations.SerializedName

data class Car(
    @SerializedName("start_street")
    val startStreet: String,
    @SerializedName("end_street")
    val endStreet: String,
    @SerializedName("route")
    val route: String
)

package com.example.weatherapp.model


import com.google.gson.annotations.SerializedName

data class Coord(
    @SerializedName("lat")
    val lat: Double? = null,
    @SerializedName("lon")
    val lon: Double? = null
)
package com.example.weatherapp.network

import com.example.weatherapp.model.Responce
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL ="https://api.openweathermap.org/data/2.5/"

private val retrofit= Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()


interface WeatherApiService{
    @GET("weather")
    suspend fun getWeatherData(@Query("q") q : String,
                              @Query("appid") appid:String) : Responce
}

object WeatherApi{
       val weatherApiService :WeatherApiService by lazy {
           retrofit.create(WeatherApiService::class.java)
       }
}
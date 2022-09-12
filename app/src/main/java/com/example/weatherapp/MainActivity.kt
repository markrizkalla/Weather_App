package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.view.LayoutInflater
import android.widget.TextView
import com.example.weatherapp.databinding.ActivityMainBinding
import com.example.weatherapp.network.WeatherApi
import com.example.weatherapp.network.WeatherApiService
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    val key = "b8475e72e81de51813e81e301709ddfb"
    lateinit var city:String



    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        runBlocking {
            getWeatherData("cairo",key)
        }

    }

    private suspend fun getWeatherData(city:String , key:String){
       val result =  WeatherApi.weatherApiService.getWeatherData(city,key)

      binding.cityName.text = result.name.toString()
        binding.currentTemp.text = result.main?.temp.toString()
        binding.humidity.text = result.main?.humidity.toString()
        binding.maxTem.text = result.main?.tempMax.toString()
        binding.minTemp.text = result.main?.tempMin.toString()

    }
}
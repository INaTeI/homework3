package com.example.homework3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.homework3.data.api.CountriesApi
import com.example.homework3.data.repository.CountriesRepository
import com.example.homework3.presentation.navigation.NavGraph
import com.example.homework3.presentation.list.CountriesViewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory




class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val api = Retrofit.Builder()
            .baseUrl("https://restcountries.com/v3.1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CountriesApi::class.java)

        val repository = CountriesRepository(api)
        val viewModel = CountriesViewModel(repository)

        setContent {
            NavGraph(viewModel)
        }
    }
}



package com.example.homework3.data.api

import com.example.homework3.data.model.CountryDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CountriesApi {

    @GET("all")
    suspend fun getAllCountries(): List<CountryDto>

    @GET("alpha/{code}")
    suspend fun getCountryByCode(
        @Path("code") code: String
    ): List<CountryDto>
}

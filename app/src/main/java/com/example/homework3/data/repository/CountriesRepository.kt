package com.example.homework3.data.repository

import com.example.homework3.data.api.CountriesApi
import com.example.homework3.data.model.Country
import com.example.homework3.data.model.toDomain

class CountriesRepository(
    private val api: CountriesApi
) {
    suspend fun getCountries(): List<Country> =
        api.getAllCountries().map { it.toDomain() }

    suspend fun getCountry(code: String): Country =
        api.getCountryByCode(code).first().toDomain()
}

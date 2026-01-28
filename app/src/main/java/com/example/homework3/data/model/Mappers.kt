package com.example.homework3.data.model

fun CountryDto.toDomain(): Country =
    Country(
        code = cca2,
        name = name.common,
        capital = capital?.firstOrNull() ?: "—",
        region = region,
        population = population,
        flagUrl = flags.png
    )

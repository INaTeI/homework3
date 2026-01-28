package com.example.homework3.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.example.homework3.presentation.list.CountriesScreen
import com.example.homework3.presentation.list.CountriesViewModel
import com.example.homework3.presentation.detail.CountryDetailScreen

@Composable
fun NavGraph(
    viewModel: CountriesViewModel
) {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "list") {

        composable("list") {
            CountriesScreen(
                state = viewModel.state,
                onCountryClick = { code ->
                    navController.navigate("detail/$code")
                },
                onRetry = {
                    viewModel.loadCountries()
                }
            )
        }

        composable("detail/{code}") {
            val code = it.arguments?.getString("code")!!
            CountryDetailScreen(code)
        }
    }
}

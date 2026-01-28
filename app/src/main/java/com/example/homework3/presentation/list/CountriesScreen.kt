package com.example.homework3.presentation.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.homework3.data.model.Country
import com.example.homework3.presentation.UiState

@Composable
fun CountriesScreen(
    state: UiState<List<Country>>,
    onCountryClick: (String) -> Unit,
    onRetry: () -> Unit
) {
    when (state) {
        UiState.Loading -> CircularProgressIndicator()

        UiState.Empty -> Text("Ничего не найдено")

        is UiState.Error ->
            Button(onClick = onRetry) {
                Text("Повторить")
            }

        is UiState.Success -> LazyColumn {
            items(state.data) { country ->
                Text(
                    text = country.name,
                    modifier = Modifier.clickable {
                        onCountryClick(country.code)
                    }
                )
            }
        }
    }
}

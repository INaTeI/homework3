package com.example.homework3.presentation.list

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework3.data.model.Country
import com.example.homework3.data.repository.CountriesRepository
import com.example.homework3.presentation.UiState
import kotlinx.coroutines.launch

class CountriesViewModel(
    private val repository: CountriesRepository
) : ViewModel() {

    var state by mutableStateOf<UiState<List<Country>>>(UiState.Loading)
        private set

    fun loadCountries() {
        viewModelScope.launch {



            state = UiState.Loading


            try {
                val data = repository.getCountries()
                state = if (data.isEmpty())
                    UiState.Empty
                else
                    UiState.Success(data)
            } catch (e: Exception) {
                state = UiState.Error("Ошибка загрузки...")
            }
        }
    }
}

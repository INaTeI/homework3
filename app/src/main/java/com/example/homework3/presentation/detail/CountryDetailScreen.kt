package com.example.homework3.presentation.detail

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun CountryDetailScreen(code: String) {
    Text(text = "Детали страны: $code")
}

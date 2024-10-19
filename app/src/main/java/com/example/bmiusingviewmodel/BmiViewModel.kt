package com.example.bmiusingviewmodel

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class BmiViewModel : ViewModel() {
    var heightInput by mutableStateOf("")
        private set

    var weightInput by mutableStateOf("")
        private set

    var bmi by mutableStateOf(0.0)
        private set

    fun onHeightInputChange(newHeight: String) {
        heightInput = newHeight.replace(',', '.')
        calculateBmi()
    }

    fun onWeightInputChange(newWeight: String) {
        weightInput = newWeight.replace(',', '.')
        calculateBmi()
    }

    private fun calculateBmi() {
        val height = heightInput.toFloatOrNull()?.div(100) ?: 0.0f
        val weight = weightInput.toIntOrNull() ?: 0
        bmi = if (weight > 0 && height > 0) (weight / (height * height)).toDouble() else 0.0
    }
}
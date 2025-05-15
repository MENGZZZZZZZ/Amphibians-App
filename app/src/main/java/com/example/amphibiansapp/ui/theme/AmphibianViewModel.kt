package com.example.amphibiansapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class AmphibianViewModel : ViewModel() {
    private val repository = NetworkAmphibianRepository()

    private val _amphibians = MutableStateFlow<List<Amphibian>>(emptyList())
    val amphibians: StateFlow<List<Amphibian>> = _amphibians

    init {
        viewModelScope.launch {
            _amphibians.value = repository.getAmphibians()
        }
    }
}

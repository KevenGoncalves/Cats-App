package com.example.cats.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cats.api.ApiResponse
import com.example.cats.api.Cat
import com.example.cats.api.CatRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val _repository: CatRepository
) : ViewModel() {

    private val _cats = MutableStateFlow<List<Cat>>(emptyList())
    val cats = _cats.asStateFlow()

    private val _message = MutableStateFlow<String?>(null)
    val message = _message.asStateFlow()

    init {
        viewModelScope.launch {
            when (val result = _repository.getCatFacts()) {
                is ApiResponse.Success -> {
                    _cats.value = result.data
                }

                is ApiResponse.Error -> {
                    _message.value = result.message
                }
            }
        }
    }
}
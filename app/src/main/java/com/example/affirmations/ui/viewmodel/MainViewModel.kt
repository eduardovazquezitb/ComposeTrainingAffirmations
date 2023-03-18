package com.example.affirmations.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.affirmations.data.Datasource
import com.example.affirmations.model.MainUiState
import com.example.affirmations.model.UiAffirmation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(
        MainUiState(
            mutableListOf(),
            isError = false,
            isLoading = true
        )
    )

    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()

    fun getAffirmations(number: Int) {
        val affirmations = Datasource().loadAffirmations(number)

        if(affirmations.size == number)
            _uiState.update { currentState ->
                currentState.copy(
                    affirmations = affirmations.mapIndexed { index, affirmation ->
                        UiAffirmation(index, affirmation, false)
                    }.toMutableList(),
                    isLoading = false
                )
            }
        else
            _uiState.update { currentState ->
                currentState.copy(
                    isLoading = false,
                    isError = true
                )
            }
    }

    fun toggleAffirmationDescription(index: Int){

        if(index < 0 || index >= _uiState.value.affirmations.size){
            _uiState.update {
                it.copy(isError = true)
            }
            return
        }

        val newAffirmations = mutableListOf<UiAffirmation>()
        _uiState.value.affirmations.forEach{
            if(it.index == index)
                newAffirmations.add(it.copy(isExpanded = ! it.isExpanded))
            else
                newAffirmations.add(it)
        }

        _uiState.update { currentState ->
            currentState.copy(affirmations = newAffirmations)
        }
    }
}
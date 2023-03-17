package com.example.affirmations.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.affirmations.data.Datasource
import com.example.affirmations.model.Affirmation
import com.example.affirmations.model.DetailUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DetailViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<DetailUiState>(
        DetailUiState(
            affirmation = Affirmation(
                0,
                0,
                0,
                0,
                0,
                0,
                0
            ),
            isLoading = true,
            isError = false
        )
    )

    val uiState: StateFlow<DetailUiState> = _uiState.asStateFlow()

    fun loadAffirmation(id: Int) {
        val affirmation = Datasource().loadAffirmation(id)
        if(affirmation != null)
            _uiState.update {
                DetailUiState(
                    affirmation = affirmation,
                    isLoading = false,
                    isError = false
                )
            }
        else
            setErrorLayout()
    }

    fun setErrorLayout(){
        _uiState.update {
            it.copy(
                isLoading = false,
                isError = true
            )
        }
    }
}
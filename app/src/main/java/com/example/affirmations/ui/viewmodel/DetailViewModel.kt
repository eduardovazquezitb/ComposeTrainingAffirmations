package com.example.affirmations.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.affirmations.R
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
                1,
                R.string.affirmation1,
                R.drawable.image1,
                R.string.description1,
                R.string.to1,
                R.string.subject1,
                R.string.phone1
            ),
            isLoading = true,
            isError = false
        )
    )

    val uiState: StateFlow<DetailUiState> = _uiState.asStateFlow()

    fun loadAffirmation(id: Int) {
        val affirmation : Affirmation? = Datasource().loadAffirmation(id)
        Log.i(null, affirmation.toString())
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
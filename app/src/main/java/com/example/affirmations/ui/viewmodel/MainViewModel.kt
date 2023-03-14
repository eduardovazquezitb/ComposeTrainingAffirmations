package com.example.affirmations.ui.viewmodel

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModel
import com.example.affirmations.DetailActivity
import com.example.affirmations.data.Datasource
import com.example.affirmations.model.Affirmation
import com.example.affirmations.ui.navigation.MainNavigator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(mutableListOf<Affirmation>())

    val uiState: StateFlow<List<Affirmation>> = _uiState.asStateFlow()

    init {
        _uiState.value = Datasource().loadAffirmations() as MutableList<Affirmation>
    }
}
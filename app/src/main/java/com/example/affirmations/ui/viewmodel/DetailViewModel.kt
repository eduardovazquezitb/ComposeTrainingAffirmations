package com.example.affirmations.ui.viewmodel

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.ContactsContract.Data
import androidx.lifecycle.ViewModel
import com.example.affirmations.data.Datasource
import com.example.affirmations.model.Affirmation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class DetailViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<Affirmation?>(null)

    val uiState: StateFlow<Affirmation?> = _uiState.asStateFlow()

    fun loadAffirmation(id: Int) {
        _uiState.value = Datasource().loadAffirmation(id)
    }
}
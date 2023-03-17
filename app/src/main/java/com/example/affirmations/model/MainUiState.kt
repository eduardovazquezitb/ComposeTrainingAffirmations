package com.example.affirmations.model

data class MainUiState (
    val affirmations: MutableList<UiAffirmation>,
    val isLoading: Boolean,
    val isError: Boolean
)
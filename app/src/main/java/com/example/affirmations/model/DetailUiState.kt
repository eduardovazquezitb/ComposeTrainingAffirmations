package com.example.affirmations.model

data class DetailUiState (
    val affirmation: Affirmation,
    val isLoading: Boolean,
    val isError: Boolean
)
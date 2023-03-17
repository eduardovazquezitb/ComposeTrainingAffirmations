package com.example.affirmations.model

data class UiAffirmation (
    val index: Int,
    val affirmation: Affirmation,
    var isExpanded: Boolean
)
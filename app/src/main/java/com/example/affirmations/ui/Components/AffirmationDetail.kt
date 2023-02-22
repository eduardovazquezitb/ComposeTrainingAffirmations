package com.example.affirmations.ui.Components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.affirmations.AffirmationCard
import com.example.affirmations.model.Affirmation

@Composable
fun AffirmationDetail (
    affirmation : Affirmation?,
    modifier: Modifier = Modifier
){
    if(affirmation != null)
        AffirmationCard(
            affirmation,
            modifier
        )
}
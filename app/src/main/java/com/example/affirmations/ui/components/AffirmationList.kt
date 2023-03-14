package com.example.affirmations.ui.components

import android.content.Context
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.affirmations.AffirmationCard
import com.example.affirmations.model.Affirmation

@Composable
fun AffirmationList(
    affirmationList: List<Affirmation>,
    modifier: Modifier = Modifier,
) {
    // TODO 3. Wrap affirmation card in a lazy column
    LazyColumn(){
        item{ Spacer(modifier = Modifier.padding(4.dp))}
        this.items(items = affirmationList, itemContent = { item ->
            AffirmationCard(
                affirmation = item,
                modifier = modifier,
            )
        } )
    }
}
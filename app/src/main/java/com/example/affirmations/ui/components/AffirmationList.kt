package com.example.affirmations.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.affirmations.AffirmationCard
import com.example.affirmations.model.UiAffirmation

@Composable
fun AffirmationList(
    uiAffirmationList: List<UiAffirmation>,
    toggleAffirmation: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(){
        item{ Spacer(modifier = Modifier.padding(4.dp))}
        this.items(items = uiAffirmationList, itemContent = { item ->
            AffirmationCard(
                affirmation = item.affirmation,
                isExpanded = item.isExpanded,
                toggleAffirmation = { toggleAffirmation(item.index) },
                modifier = modifier,
            )
        } )
    }
}
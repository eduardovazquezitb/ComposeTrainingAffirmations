package com.example.affirmations.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.affirmations.model.Affirmation

@Composable
fun DescriptionCard (
    affirmation : Affirmation,
    modifier : Modifier = Modifier
) {
    Card(
        elevation = 8.dp,
        shape = RoundedCornerShape(15.dp),
        backgroundColor = MaterialTheme.colors.secondary,
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp, bottom = 8.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = modifier.padding(12.dp).fillMaxWidth()
        )
        {
            Text(
                text = stringResource(id = affirmation.stringResourceId),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.primary,
            )
            Spacer(modifier = modifier.padding(4.dp))
            Text(
                text = stringResource(id = affirmation.descriptionResourceId),
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = MaterialTheme.colors.primary
            )
        }
    }
}
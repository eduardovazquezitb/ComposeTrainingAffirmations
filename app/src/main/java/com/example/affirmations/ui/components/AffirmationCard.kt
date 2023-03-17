package com.example.affirmations

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.affirmations.model.Affirmation
import com.example.affirmations.ui.components.DescriptionDisplayer
import com.example.affirmations.ui.components.ExpandButton

@Composable
fun AffirmationCard(
    affirmation: Affirmation,
    isExpanded: Boolean,
    toggleAffirmation: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = 8.dp,
        shape = RoundedCornerShape(15.dp),
        backgroundColor = MaterialTheme.colors.primaryVariant,
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp, bottom = 8.dp)
    ) {
        Column(
            modifier = modifier.fillMaxWidth()
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
                .fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
                    .background(color = MaterialTheme.colors.secondaryVariant)
                    .fillMaxWidth()
            ) {
                Spacer(modifier = modifier.padding(4.dp))
                Image(
                    painter = painterResource(id = affirmation.imageResourceId),
                    contentDescription = stringResource(id = affirmation.stringResourceId),
                    contentScale = ContentScale.Crop,
                    modifier = modifier.padding(8.dp).size(75.dp).clip(CircleShape)
                )
                Spacer(modifier = Modifier.padding(4.dp))
                Text(
                    text = stringResource(id = affirmation.stringResourceId),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.primary,
                    modifier = modifier.weight(1F)
                )
                Spacer(modifier = modifier.padding(4.dp))
                ExpandButton(
                    modifier.size(50.dp),
                    onClick = { toggleAffirmation() },
                    isExpanded = isExpanded
                )
                Spacer(modifier = modifier.padding(4.dp))
            }
            if (isExpanded) {
                DescriptionDisplayer(
                    affirmation,
                    modifier,
                )
            }
        }
    }
}
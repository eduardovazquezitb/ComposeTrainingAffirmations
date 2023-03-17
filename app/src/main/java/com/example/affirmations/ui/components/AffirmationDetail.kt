package com.example.affirmations.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.affirmations.R
import com.example.affirmations.model.Affirmation

@Composable
fun AffirmationDetail (
    affirmation : Affirmation?,
    modifier: Modifier = Modifier
){
    if(affirmation != null){
        LazyColumn(
            modifier = modifier
                .padding(8.dp)
                .fillMaxWidth()
        ){
            item{
                Image(
                    painter = painterResource(id = affirmation.imageResourceId),
                    contentDescription = stringResource(id = affirmation.stringResourceId),
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                        .fillMaxWidth()
                        .size(160.dp)
                        .clip(shape = RoundedCornerShape(24.dp))
                )
            }
            item{
                Spacer(modifier = modifier.padding(8.dp))
            }
            item {
                DescriptionCard(
                    affirmation,
                    modifier
                )
            }
            item{
                Spacer(modifier = modifier.padding(8.dp))
            }
            item{
                CallAndShareButtons(
                    to = stringResource(id = affirmation.toResourceId),
                    subject = stringResource(id = affirmation.subjectResourceId),
                    phone = stringResource(id = affirmation.phoneResourceId),
                    modifier
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AffirmationDetailPreview() {
    AffirmationDetail(
        Affirmation(1, R.string.affirmation1, R.drawable.image1, R.string.description1, R.string.to1, R.string.subject1, R.string.phone1)
    )
}
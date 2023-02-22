package com.example.affirmations.ui.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.affirmations.model.Affirmation

@Composable
fun DescriptionDisplayer(
    affirmation: Affirmation,
    modifier : Modifier = Modifier,
    openDetail : ((Affirmation)->Unit)? = null
){
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.primaryVariant)
    ){
        Spacer(modifier = modifier.padding(top = 8.dp))
        Text(
            text = stringResource(id = com.example.affirmations.R.string.description_title),
            fontSize = 20.sp,
            fontWeight = FontWeight.ExtraBold,
            color = MaterialTheme.colors.secondary,
            modifier = modifier.padding(start = 12.dp)
        )
        Spacer(modifier = modifier.padding(top = 4.dp))
        Row(
            modifier = modifier
        ){
            Spacer(modifier = modifier.padding(8.dp))
            Text(
                text = stringResource(id = affirmation.descriptionResourceId),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.primary,
                modifier = modifier.weight(1F)
            )
            Spacer(modifier = modifier.padding(8.dp))
        }
        Spacer(modifier = modifier.padding(top = 12.dp))
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = modifier.fillMaxWidth()
        ){
            Button(
                modifier = modifier.padding(bottom = 8.dp, end = 12.dp),
                onClick = {
                    if(openDetail != null)
                        openDetail(affirmation)
                }
            ) {
                Text(
                    text = stringResource(id = com.example.affirmations.R.string.detail_fragment),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = modifier
                )
            }
        }
    }
}
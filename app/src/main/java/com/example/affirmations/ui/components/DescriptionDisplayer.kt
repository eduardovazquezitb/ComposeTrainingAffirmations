package com.example.affirmations.ui.components

import android.app.Activity
import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.affirmations.model.Affirmation
import com.example.affirmations.ui.navigation.MainNavigator

@Composable
fun DescriptionDisplayer(
    affirmation: Affirmation,
    modifier : Modifier = Modifier
){
    val navigator= MainNavigator()
    val activity = LocalContext.current as Activity
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
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.primary,
                modifier = modifier.weight(1F),
                overflow = TextOverflow.Ellipsis,
                maxLines = 2
            )
            Spacer(modifier = modifier.padding(4.dp))
            TextButton(
                modifier = modifier
                    .padding(bottom = 8.dp, end = 12.dp),
                onClick = {
                    navigator.goToDetail(activity, affirmation.id)
                }
            ) {
                Text(
                    text = stringResource(id = com.example.affirmations.R.string.detail_fragment),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier
                )
            }
        }
    }
}
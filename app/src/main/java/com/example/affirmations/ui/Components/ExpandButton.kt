package com.example.affirmations.ui.Components

import androidx.compose.foundation.clickable
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.affirmations.R

@Composable
fun ExpandButton(
    modifier :Modifier = Modifier,
    onClick : (()->Unit)? = null,
    isExpanded : Boolean = false
){
    Icon(
        imageVector = if(isExpanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
        tint = MaterialTheme.colors.secondary,
        contentDescription = stringResource(R.string.expand_button_content_description),
        modifier = modifier.clickable { onClick!!() }
    )
}
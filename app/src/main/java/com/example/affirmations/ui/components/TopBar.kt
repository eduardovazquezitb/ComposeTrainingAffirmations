package com.example.affirmations.ui.components

import androidx.compose.material.icons.filled.FormatPaint
import com.example.affirmations.R

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun TopBar(
    activityName: String,
    modifier : Modifier = Modifier,
    onGoBackButton: (() -> Unit)? = null,
    onThemeClick: (() -> Unit)? = null
) {
    TopAppBar(
        /*navigationIcon = {
            IconButton(onClick = { }) {
                Icon(
                    painter = painterResource(id = com.example.temtemreference.R.drawable.logo),
                    contentDescription = stringResource(id = com.example.temtemreference.R.string.app_name),
                    tint = Color.Unspecified,
                    modifier = modifier.clickable { onGoBackClick!!() }
                )
            }
        },*/
        title = {
            Text(
                text = activityName,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                modifier = modifier /*.clickable {  }*/
            ) },
        actions = {
            if(onGoBackButton != null){
                IconButton(onClick = { onGoBackButton() } ) {
                    Icon(
                        imageVector = Icons.Filled.Home,
                        contentDescription = stringResource(id = R.string.change_theme)
                    )
                }
            }
            if(onThemeClick != null){
                IconButton(onClick = { onThemeClick() } ) {
                    Icon(
                        imageVector = Icons.Filled.FormatPaint,
                        contentDescription = stringResource(id = R.string.change_theme)
                    )
                }
            }
        }
    )
}

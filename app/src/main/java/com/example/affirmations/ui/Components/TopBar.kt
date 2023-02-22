package com.example.affirmations.ui.Components

import androidx.compose.material.icons.filled.FormatPaint
import com.example.affirmations.R

import androidx.compose.foundation.clickable
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

@Composable
fun TopBar(
    appState: AppState,
    modifier : Modifier = Modifier,
    onHomeClick: (()-> Unit)? = null,
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
                text = stringResource(id = R.string.app_name),
                modifier = modifier.clickable { if(appState != AppState.AffirmationList && onHomeClick != null) onHomeClick() }
            ) },
        actions = {
            IconButton(onClick = { if(onThemeClick != null) onThemeClick() }) {
                Icon(
                    imageVector = Icons.Filled.FormatPaint,
                    contentDescription = stringResource(id = R.string.change_theme)
                )
            }

            if(appState != AppState.AffirmationList) {
                IconButton(onClick = { if(onHomeClick != null) onHomeClick() }) {
                    Icon(
                        imageVector = Icons.Filled.Home,
                        contentDescription = stringResource(id = R.string.app_name)
                    )
                }
            }
        }
    )
}

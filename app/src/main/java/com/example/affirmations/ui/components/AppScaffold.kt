package com.example.affirmations.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.affirmations.ui.theme.AffirmationsTheme

@Composable
fun AppScaffold(
    activityName: String,
    onGoBackButton: (() -> Unit)? = null,
    isLoading: Boolean,
    isError: Boolean,
    children: @Composable (modifier: Modifier) -> Unit,
) {
    val darkThemeState = remember { mutableStateOf(false) }
    // TODO 4. Apply Theme and affirmation list
    AffirmationsTheme(darkTheme = darkThemeState.value) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = { TopBar(
                activityName,
                onGoBackButton = onGoBackButton,
                onThemeClick = { darkThemeState.value = ! darkThemeState.value}
            ) },
        ) { padding ->
            if(isLoading)
                Loadingcomponent(modifier = Modifier.padding(padding))
            else if (isError)
                ErrorComponent(modifier = Modifier.padding(padding))
            else
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize().background(MaterialTheme.colors.secondary)
                ) {
                        children(modifier=Modifier.padding(padding))
                }
        }
    }
}
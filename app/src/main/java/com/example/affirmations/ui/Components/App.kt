package com.example.affirmations.ui.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.affirmations.data.Datasource
import com.example.affirmations.model.Affirmation
import com.example.affirmations.ui.theme.AffirmationsTheme

enum class AppState {
    AffirmationList,
    AffirmationDetail
}

@Composable
fun App() {
    val appState = remember { mutableStateOf<AppState>(AppState.AffirmationList)}
    val darkThemeState = remember { mutableStateOf(false) }
    val chosenAffirmation = remember { mutableStateOf<Affirmation?> (null)}
    // TODO 4. Apply Theme and affirmation list
    AffirmationsTheme(darkTheme = darkThemeState.value) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = { TopBar(
                appState.value,
                onHomeClick = { appState.value = AppState.AffirmationList },
                onThemeClick = { darkThemeState.value = !darkThemeState.value }
            ) },
        ) { padding ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize().background(MaterialTheme.colors.secondary)
            ) {
                when (appState.value) {
                    AppState.AffirmationList ->
                        AffirmationList(
                            affirmationList = Datasource().loadAffirmations(),
                            modifier = Modifier.padding(padding),
                            openDetail = { affirmation ->
                                chosenAffirmation.value = affirmation
                                appState.value = AppState.AffirmationDetail
                            }
                        )
                    AppState.AffirmationDetail ->
                        AffirmationDetail(
                            chosenAffirmation.value,
                            modifier = Modifier.padding(padding)
                        )
                }
            }
        }
    }
}
package com.example.affirmations.ui.components

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.example.affirmations.ui.viewmodel.DetailViewModel

@Composable
fun DetailActivityDisplay(
    viewModel: DetailViewModel
) {
    val uiState by viewModel.uiState.collectAsState()
    val activity = LocalContext.current as Activity

    AppScaffold(
        activityName = stringResource(id = uiState.affirmation.stringResourceId),
        onGoBackButton = { activity.finish() },
        isLoading = uiState.isLoading,
        isError = uiState.isError
    ) {
        AffirmationDetail(
            uiState.affirmation
        )
    }
}
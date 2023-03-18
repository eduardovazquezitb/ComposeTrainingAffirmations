package com.example.affirmations.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import com.example.affirmations.ui.viewmodel.MainViewModel

@Composable
fun MainActivityDisplay(
    viewModel: MainViewModel
){
    val uiState by viewModel.uiState.collectAsState()

    AppScaffold(
        activityName = stringResource(id = com.example.affirmations.R.string.app_name),
        isLoading = uiState.isLoading,
        isError = uiState.isError
    ){
        AffirmationList(
            uiAffirmationList = uiState.affirmations,
            toggleAffirmation = {index ->
                viewModel.toggleAffirmationDescription(index)
            }
        )
    }
}
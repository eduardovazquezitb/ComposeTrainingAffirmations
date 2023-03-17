package com.example.affirmations.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.affirmations.data.Datasource
import com.example.affirmations.model.UiAffirmation
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

@Preview
@Composable
private fun AffirmationCardPreview() {
    AppScaffold(
        activityName = stringResource(id = com.example.affirmations.R.string.app_name),
        isLoading = false,
        isError = false
    ){
        AffirmationList(
            uiAffirmationList = Datasource().loadAffirmations().mapIndexed { index, affirmation -> UiAffirmation(index, affirmation, false) },
            toggleAffirmation = {}
        )
    }
}
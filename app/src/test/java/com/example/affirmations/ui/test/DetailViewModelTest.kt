package com.example.affirmations.ui.test

import com.example.affirmations.ui.viewmodel.DetailViewModel
import org.junit.*
import org.junit.Assert.*

class DetailViewModelTest {
    private val viewModel = DetailViewModel()

    @Test
    fun detailViewModel_ViewModelStarts_StateIsLoading() {
        val uiState = viewModel.uiState.value

        assertTrue(uiState.isLoading)
        assertFalse(uiState.isError)
    }

    @Test
    fun detailViewModel_Load1stAffirmation_StateIsNotLoadingNorError() {
        viewModel.loadAffirmation(1)
        val uiState = viewModel.uiState.value

        assertFalse(uiState.isLoading)
        assertFalse(uiState.isError)
    }

    @Test
    fun detailViewModel_Load11thAffirmation_StateIsError(){
        viewModel.loadAffirmation(11)
        val uiState = viewModel.uiState.value

        assertFalse(uiState.isLoading)
        assertTrue(uiState.isError)
    }
}
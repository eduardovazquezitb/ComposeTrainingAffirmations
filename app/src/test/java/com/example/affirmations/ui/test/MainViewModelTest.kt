package com.example.affirmations.ui.test

import com.example.affirmations.ui.viewmodel.MainViewModel
import org.junit.*
import org.junit.Assert.*

class MainViewModelTest {
    private val viewModel = MainViewModel()

    @Test
    fun mainViewModel_ViewModelStarts_StateIsLoadingAndHasNoAffirmations(){
        val uiState = viewModel.uiState.value

        assertTrue(uiState.isLoading)
        assertFalse(uiState.isError)
        assertEquals(uiState.affirmations.size, 0)
    }

    @Test
    fun mainViewModel_Load5Affirmations_StateIsNotLoadingAndHas5Affirmations(){
        viewModel.getAffirmations(5)
        val uiState = viewModel.uiState.value

        assertFalse(uiState.isLoading)
        assertFalse(uiState.isError)
        assertEquals(uiState.affirmations.size, 5)
    }

    @Test
    fun mainViewModel_Load10Affirmations_StateIsNotLoadingAndHas10Affirmations(){
        viewModel.getAffirmations(10)
        val uiState = viewModel.uiState.value

        assertFalse(uiState.isLoading)
        assertFalse(uiState.isError)
        assertEquals(uiState.affirmations.size, 10)
    }

    @Test
    fun mainViewModel_Load11Affirmations_StateIsErrorAndHas0Affirmations(){
        viewModel.getAffirmations(11)
        val uiState = viewModel.uiState.value

        assertFalse(uiState.isLoading)
        assertTrue(uiState.isError)
        assertEquals(uiState.affirmations.size, 0)
    }

    @Test
    fun mainViewModel_ToggleThirdAffirmation_ThirdAffirmationIsExpanded(){
        viewModel.getAffirmations(5)
        viewModel.toggleAffirmationDescription(3)
        val uiState = viewModel.uiState.value

        assertFalse(uiState.isLoading)
        assertFalse(uiState.isError)
        assertTrue(uiState.affirmations[3].isExpanded)
    }

    @Test
    fun mainViewModel_ToggleThirdAffirmationTwice_ThirdAffirmationIsNotExpanded(){
        viewModel.getAffirmations(5)
        viewModel.toggleAffirmationDescription(3)
        viewModel.toggleAffirmationDescription(3)
        val uiState = viewModel.uiState.value

        assertFalse(uiState.isLoading)
        assertFalse(uiState.isError)
        assertFalse(uiState.affirmations[3].isExpanded)
    }
}
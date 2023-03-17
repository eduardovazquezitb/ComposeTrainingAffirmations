package com.example.affirmations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.affirmations.ui.components.DetailActivityDisplay
import com.example.affirmations.ui.viewmodel.DetailViewModel

class DetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = DetailViewModel()
        val extras = intent.extras

        if(extras != null)
            viewModel.loadAffirmation(extras.getInt("affirmation"))
        else
            viewModel.setErrorLayout()

        setContent {
            DetailActivityDisplay(
                viewModel = viewModel
            )
        }
    }
}
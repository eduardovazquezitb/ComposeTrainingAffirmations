package com.example.affirmations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.affirmations.ui.components.DetailActivityDisplay
import com.example.affirmations.ui.viewmodel.DetailViewModel

class DetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val viewModel : DetailViewModel = viewModel()
            val extras = intent.extras

            if(extras != null)
                viewModel.loadAffirmation(extras.getInt("affirmation"))
            else
                viewModel.setErrorLayout()

            DetailActivityDisplay(
                viewModel = viewModel
            )
        }
    }
}
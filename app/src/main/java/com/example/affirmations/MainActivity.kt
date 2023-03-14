/*
 * Copyright (C) 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.affirmations

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.affirmations.data.Datasource
import com.example.affirmations.ui.components.AffirmationList
import com.example.affirmations.ui.components.AppScaffold
import com.example.affirmations.ui.navigation.MainNavigator
import com.example.affirmations.ui.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    this.setContent {

      val viewModel = MainViewModel()
      val affirmationList by viewModel.uiState.collectAsState()

      AppScaffold(
        activityName = stringResource(id = R.string.app_name)
      ){
        AffirmationList(
          affirmationList = affirmationList
        )
      }
    }
  }

  fun goToDetail(affirmationId: Int){
    val intent = Intent(this, DetailActivity::class.java)
    intent.putExtra("affirmation", affirmationId)
    this.startActivity(intent)
  }
}

@Preview
@Composable
private fun AffirmationCardPreview() {
  // TODO 2. Preview your card
  AppScaffold(
    activityName = stringResource(id = R.string.app_name)
  ){
    AffirmationList(
      affirmationList = Datasource().loadAffirmations()
    )
  }
}

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

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.affirmations.data.Datasource
import com.example.affirmations.model.Affirmation
import com.example.affirmations.ui.theme.AffirmationsTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    this.setContent {
      // TODO 5. Show screen
      AffirmationApp()
    }
  }
}

@Composable
fun AffirmationApp() {
  val darkThemeState = remember { mutableStateOf(false) }
  // TODO 4. Apply Theme and affirmation list
  AffirmationsTheme(darkTheme = darkThemeState.value) {
    Column(
      horizontalAlignment = Alignment.CenterHorizontally,
      modifier = Modifier.fillMaxSize().background(MaterialTheme.colors.secondary)
    ) {
      Button(
        onClick = { darkThemeState.value = ! darkThemeState.value },
        modifier = Modifier.background(color = MaterialTheme.colors.secondary)
      ) {
        Text(
          text = stringResource(id = com.example.affirmations.R.string.change_theme),
          // color = MaterialTheme.colors.secondary
        )
      }
      AffirmationList(affirmationList = Datasource().loadAffirmations())
    }
  }
}

@Composable
fun AffirmationList(affirmationList: List<Affirmation>, modifier: Modifier = Modifier) {
  // TODO 3. Wrap affirmation card in a lazy column
  LazyColumn(){
    this.items(items = affirmationList, itemContent = { item ->
      AffirmationCard(affirmation = item, modifier = modifier)
    } )
  }
}

@Preview
@Composable
private fun AffirmationCardPreview() {
  // TODO 2. Preview your card
  AffirmationApp()
}

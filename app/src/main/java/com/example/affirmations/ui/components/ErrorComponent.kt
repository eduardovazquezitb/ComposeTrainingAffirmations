package com.example.affirmations.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.affirmations.R.*

@Composable
fun ErrorComponent(
    modifier: Modifier=Modifier
)
{
    Text(
        text = stringResource(id = string.error),
        fontSize = 20.sp,
        modifier = modifier.padding(top=12.dp)
    )
}

@Preview
@Composable
private fun LoadingComponentPreview() {
    ErrorComponent()
}
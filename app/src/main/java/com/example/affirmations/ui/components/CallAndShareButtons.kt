package com.example.affirmations.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Mail
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.affirmations.R
import com.example.affirmations.ui.navigation.DetailNavigator

@Composable
fun CallAndShareButtons(
    to: String,
    subject: String,
    phone: String,
    modifier: Modifier = Modifier
){
    val navigator= DetailNavigator()
    val context = LocalContext.current
    Row(
        horizontalArrangement = Arrangement.End,
        modifier = modifier.fillMaxWidth()
    ){
        IconButton(onClick = {
                navigator.sendMail(context, to, subject)
        } ) {
            Icon(
                imageVector = Icons.Filled.Mail,
                contentDescription = stringResource(id = R.string.share_quote),
                modifier = modifier.size(32.dp)
            )
        }
        IconButton(onClick = { navigator.dial(context,phone) } ) {
            Icon(
                imageVector = Icons.Filled.Call,
                contentDescription = stringResource(id = R.string.call),
                modifier = modifier.size(32.dp)
            )
        }
        Spacer(modifier = modifier.padding(8.dp))
    }
}
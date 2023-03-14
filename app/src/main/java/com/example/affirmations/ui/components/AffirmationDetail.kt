package com.example.affirmations.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Mail
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.affirmations.R
import com.example.affirmations.model.Affirmation

@Composable
fun AffirmationDetail (
    affirmation : Affirmation?,
    sendMail: ((String,String) -> Unit)? = null,
    dial: ((String) -> Unit)? = null,
    modifier: Modifier = Modifier
){
    if(affirmation != null){
        LazyColumn(
            modifier = modifier
                .padding(8.dp)
                .fillMaxWidth()
        ){
            item{
                Image(
                    painter = painterResource(id = affirmation.imageResourceId),
                    contentDescription = stringResource(id = affirmation.stringResourceId),
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                        .fillMaxWidth()
                        .size(160.dp)
                        .clip(shape = RoundedCornerShape(24.dp))
                )
            }
            item{
                Spacer(modifier = modifier.padding(8.dp))
            }
            item {
                DescriptionCard(
                    affirmation,
                    modifier
                )
            }
            item{
                Spacer(modifier = modifier.padding(8.dp))
            }
            item{
                Row(
                    horizontalArrangement = Arrangement.End,
                    modifier = modifier.fillMaxWidth()
                ){
                    IconButton(onClick = { sendMail } ) {
                        Icon(
                            imageVector = Icons.Filled.Mail,
                            contentDescription = stringResource(id = R.string.share_quote),
                            modifier = modifier.size(32.dp)
                        )
                    }
                    IconButton(onClick = { /**/ } ) {
                        Icon(
                            imageVector = Icons.Filled.Call,
                            contentDescription = stringResource(id = R.string.call),
                            modifier = modifier.size(32.dp)
                        )
                    }
                    Spacer(modifier = modifier.padding(8.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AffirmationDetailPreview() {
    AffirmationDetail(
        Affirmation(1, R.string.affirmation1, R.drawable.image1, R.string.description1)
    )
}
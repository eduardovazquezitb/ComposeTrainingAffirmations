package com.example.affirmations

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.affirmations.model.Affirmation
import com.example.affirmations.ui.components.AffirmationDetail
import com.example.affirmations.ui.components.AppScaffold
import com.example.affirmations.ui.viewmodel.DetailViewModel

class DetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = DetailViewModel()
        val extras = intent.extras
        if(extras != null)
            viewModel.loadAffirmation(extras.getInt("affirmation"))

        setContent {
            val affirmation : Affirmation? by viewModel.uiState.collectAsState()

            if(affirmation != null) {
                AppScaffold(
                    activityName = stringResource(id = affirmation!!.stringResourceId),
                    onGoBackButton = { finish() }
                ) {
                    AffirmationDetail(
                        affirmation!!,
                        sendMail = { to, subject -> sendMail(to, subject)},
                        dial = { phone -> dial(phone)}
                    )
                }
            }
            else{
                Text(text = "loading...")
            }
        }
    }

    private fun Context.sendMail(to: String, subject: String){
        try{
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "message/rfc822"
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(to))
            intent.putExtra(Intent.EXTRA_SUBJECT, subject)
            startActivity(intent)
        } catch (e: ActivityNotFoundException){
            // TODO: Handle case where no email app is available
            Toast.makeText(getApplicationContext(), "No Email App Available", Toast.LENGTH_SHORT);
        } catch (t: Throwable){
            // TODO: Handle potential other type of exceptions
            Toast.makeText(getApplicationContext(), "Random Exception LoL", Toast.LENGTH_SHORT);
        }
    }

    private fun Context.dial(phone: String){
        try{
            val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))
            startActivity(intent)
        } catch (t: Throwable){
            // TODO: Handle potential exceptions
            Toast.makeText(getApplicationContext(), "Random Exception LoL", Toast.LENGTH_SHORT);
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppScaffold(
        activityName = stringResource(id = R.string.title_activity_detail),
    ){
        AffirmationDetail(
            Affirmation(1, R.string.affirmation1, R.drawable.image1, R.string.description1)
        )
    }
}
package com.example.affirmations.ui.navigation

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast

class DetailNavigator {
    fun sendMail(context: Context, to: String, subject: String){
        try{
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "message/rfc822"
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(to))
            intent.putExtra(Intent.EXTRA_SUBJECT, subject)
            context.startActivity(intent)
        } catch (e: ActivityNotFoundException){
            Toast.makeText(context, "No Email App Available", Toast.LENGTH_SHORT).show()
        } catch (t: Throwable){
            Toast.makeText(context, "Random Exception LoL", Toast.LENGTH_SHORT).show()
        }
    }

    fun dial(context: Context, phone: String){
        try{
            val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))
            context.startActivity(intent)
        } catch (t: Throwable){
            Toast.makeText(context, "Random Exception LoL", Toast.LENGTH_SHORT).show()
        }
    }
}
package com.example.affirmations.ui.navigation

import android.app.Activity
import android.content.Intent
import com.example.affirmations.DetailActivity

class MainNavigator {
    fun goToDetail(activity: Activity, affirmationId: Int){
        val intent = Intent(activity, DetailActivity::class.java)
        intent.putExtra("affirmation", affirmationId)
        activity.startActivity(intent)
    }
}
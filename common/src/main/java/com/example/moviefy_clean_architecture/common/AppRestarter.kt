package com.example.moviefy_clean_architecture.common

import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi

interface AppRestarter : () -> Unit

class AppRestarterImpl(val context : Context) : AppRestarter{
    @RequiresApi(Build.VERSION_CODES.CUPCAKE)
    override fun invoke() {
        val restartIntent = context.packageManager.getLaunchIntentForPackage(context.packageName)
        if(restartIntent == null){
            showError()
            return
        }
        restartIntent.addFlags(FLAG_ACTIVITY_NEW_TASK or FLAG_ACTIVITY_CLEAR_TASK)
        restartIntent.addCategory(Intent.CATEGORY_DEFAULT)
        context.startActivity(restartIntent)
        Runtime.getRuntime().exit(0)
    }

    private fun showError(){
        Toast.makeText(
            context,
            "Error while switching environment",
            Toast.LENGTH_LONG
        ).show()
    }
}
package com.example.moviefy_clean_architecture

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

class MainActivity: AppCompatActivity() {

    private lateinit var navController: NavController

    private val onDestinationChangedListener = NavController.OnDestinationChangedListener{ _, dest, _ ->
        val config = dest.config.allowBottomNav
        //TODO visible or invisible bottom nav or nav graphs
    }


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

       val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        setMainNavigation()
    }

    private fun setMainNavigation(){
        val mainNavGraph = navController.mainNavGraph()
        navController.setGraph(mainNavGraph, null)
        navController.addOnDestinationChangedListener(onDestinationChangedListener)
    }
}
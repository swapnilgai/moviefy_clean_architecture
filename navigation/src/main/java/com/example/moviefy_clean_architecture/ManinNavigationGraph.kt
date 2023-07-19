package com.example.moviefy_clean_architecture

import androidx.navigation.NavController
import androidx.navigation.NavGraph
import com.example.moviefy_clean_architecture.navigation.R

fun NavController.mainNavGraph(subGraph: Iterable<NavGraph> = emptyList()): NavGraph{
    val navGraph = navInflater.inflate(R.navigation.navigation)
    navGraph.forEach{ navDestination ->  navDestination.config = NavDestinationConfig(
        allowBottomNav = false
        )
    }
    subGraph.distinctBy { it.id }.forEach{ navGraph.addDestination(it)}
    return navGraph
}
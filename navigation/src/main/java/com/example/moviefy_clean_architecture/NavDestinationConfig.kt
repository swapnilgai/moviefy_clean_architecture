package com.example.moviefy_clean_architecture

import androidx.navigation.NavArgument
import androidx.navigation.NavDestination

private const val NAV_ARGS_VAL = "com.example.moviefy.nav"

data class NavDestinationConfig(val allowBottomNav: Boolean = false)

var NavDestination.config: NavDestinationConfig
    get() {
        return arguments[NAV_ARGS_VAL]?.defaultValue as? NavDestinationConfig ?: NavDestinationConfig()
    }
    set(value){
        addArgument(NAV_ARGS_VAL,
        NavArgument.Builder().setDefaultValue(value).build()
        )
    }
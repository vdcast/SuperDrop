package com.vdcast.superdrop.ui.navigation

sealed class Routes(val route: String) {
    object Home : Routes("Home")
    object Settings : Routes("Settings")
}
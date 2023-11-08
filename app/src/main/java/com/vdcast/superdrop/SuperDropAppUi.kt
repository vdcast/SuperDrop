package com.vdcast.superdrop

import android.app.Application
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vdcast.superdrop.domain.AppViewModel
import com.vdcast.superdrop.ui.navigation.Routes
import com.vdcast.superdrop.ui.screens.home.Home
import com.vdcast.superdrop.ui.screens.settings.Settings
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SuperDropApp : Application()

@Composable
fun SuperDropAppUi(
    appViewModel: AppViewModel = hiltViewModel(),
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Routes.Home.route,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None }
    ) {
        composable(Routes.Home.route) {
            Home(
                onButton1 = { navController.navigate(Routes.Settings.route) }
            )
        }
        composable(Routes.Settings.route) {
            Settings(
                onBack = { navController.popBackStack() }
            )
        }
    }
}
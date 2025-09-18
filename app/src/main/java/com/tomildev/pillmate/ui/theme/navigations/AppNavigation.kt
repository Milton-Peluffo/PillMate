package com.tomildev.pillmate.ui.theme.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tomildev.pillmate.ui.theme.screens.alarmForm.AlarmFormScreen
import com.tomildev.pillmate.ui.theme.screens.splashScreen.SplashScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppScreen.SplashScreen.route) {
        composable(AppScreen.SplashScreen.route){
            SplashScreen(navController)
        }
        composable(AppScreen.AlarmFormScreen.route){
            AlarmFormScreen()
        }

    }
}
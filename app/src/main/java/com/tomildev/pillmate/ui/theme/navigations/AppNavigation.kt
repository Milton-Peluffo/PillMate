package com.tomildev.pillmate.ui.theme.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tomildev.pillmate.ui.theme.screens.alarmForm.AlarmFormScreen
import com.tomildev.pillmate.ui.theme.screens.alarmList.AlarmListScreen
import com.tomildev.pillmate.ui.theme.screens.alarmList.Alarm
import com.tomildev.pillmate.ui.theme.screens.settings.SettingsScreen
import com.tomildev.pillmate.ui.theme.screens.splashScreen.SplashScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppScreen.SplashScreen.route
    ) {
        composable(AppScreen.SplashScreen.route) {
            SplashScreen(navController)
        }
        composable(AppScreen.AlarmFormScreen.route) {
            AlarmFormScreen(navController)
        }
        composable(AppScreen.SettingsScreen.route){
            SettingsScreen((navController))
        }
        composable(AppScreen.AlarmListScreen.route) {
            //Just Temp Alarms for show something on alarmList
            val sampleAlarms = listOf(
                Alarm("Sulfato de Albuterol", "3h 20m", "08:00 AM", "Todos los días", true),
                Alarm("Naproxeno", "23h 12m", "10:00 PM", "Lun, Mar, Sab", true),
                Alarm("Sulfato Ferroso", "12h 4m", "01:20 PM", "Lun, Mier, Vier, Dom", true),
                Alarm("Genoprazol", "8h 00m", "08:00 PM", "Lun, Sab", true),
                Alarm("Amoxicilina", "6h 00m", "07:00 AM", "Todos los días", true),
                Alarm("Ibuprofeno", "8h 30m", "02:30 PM", "Mar, Jue, Dom", true),
                Alarm("Vitamina D", "24h 00m", "09:00 AM", "Sab, Dom", true)

            )

            AlarmListScreen(
                navController = navController,
                alarms = sampleAlarms,
                onAddClick = {  },
                onMenuClick = { }
            )
        }
    }
}

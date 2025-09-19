package com.tomildev.pillmate.ui.theme.navigations

sealed class AppScreen(val route: String) {
    object SplashScreen : AppScreen("splash_screen")
    object AlarmFormScreen : AppScreen("alarm_form_screen")
    object AlarmListScreen : AppScreen("alarm_list_screen")
    object SettingsScreen : AppScreen("settings_screen")
}
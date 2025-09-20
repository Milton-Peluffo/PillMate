package com.tomildev.pillmate.ui.theme.navigations

sealed class AppScreens(val route: String) {
    object SplashScreen : AppScreens("splash_screen")
    object AlarmFormScreen : AppScreens("alarm_form_screen")
    object AlarmListScreen : AppScreens("alarm_list_screen")
    object SettingsScreen : AppScreens("settings_screen")
}
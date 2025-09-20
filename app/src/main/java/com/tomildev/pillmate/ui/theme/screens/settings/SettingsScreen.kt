package com.tomildev.pillmate.ui.theme.screens.settings

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tomildev.pillmate.R
import com.tomildev.pillmate.ui.theme.components.BackButton
import com.tomildev.pillmate.ui.theme.components.SettingItem
import com.tomildev.pillmate.ui.theme.navigations.AppScreens
import com.tomildev.pillmate.ui.theme.theme.FontDarkPurple

data class SettingOption(
    val id: String,
    val title: String,
    @DrawableRes val iconRes: Int? = null,
    val value: String? = null,
    val action: () -> Unit
)

val settings = listOf(
    SettingOption("Theme", "Tema de la app", R.drawable.sun_icon, value = null) {},
    SettingOption("Lang", "Lenguaje", value = "Español") {},
    SettingOption("AlarmTune", "Tono de la alarma", R.drawable.alarm_icon, value = null) {},
    SettingOption("NotifiTune", "Tono de notificación", R.drawable.bell_icon, value = null) {},
    SettingOption("DataControls", "Control de datos", R.drawable.data_icon, value = null) {},
)

@Composable
fun SettingsScreen(
    navController: NavController,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        BackButton(
            onClick = {
                navController.navigate(AppScreens.AlarmListScreen.route)
            }
        )

        Text(
            "Ajustes",
            fontSize = 38.sp,
            fontWeight = FontWeight.Bold,
            color = FontDarkPurple
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 40.dp)
        ) {
            items(settings, key = { it.id }) { s ->
                SettingItem(
                    title = s.title,
                    icon = s.iconRes?.let { painterResource(id = it) },
                    value = s.value,
                    onClick = s.action
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SettingsScreenPreview() {
    val nav = rememberNavController()
    SettingsScreen(nav)
}

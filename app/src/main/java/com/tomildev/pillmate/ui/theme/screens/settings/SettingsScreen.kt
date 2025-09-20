package com.tomildev.pillmate.ui.theme.screens.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.tomildev.pillmate.ui.theme.components.BackButton
import com.tomildev.pillmate.ui.theme.navigations.AppScreen
import com.tomildev.pillmate.ui.theme.theme.FontDarkPurple

@Composable
fun SettingsScreen(
    navController = NavController
){

    Row(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        BackButton(
            onClick = {
                navController
            }
        )

        Text(
            "Ajustes",
            fontSize = 38.sp,
            fontWeight = FontWeight.Bold,
            color = FontDarkPurple
        )
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SettingsScreenPreview(){
    SettingsScreen()
}
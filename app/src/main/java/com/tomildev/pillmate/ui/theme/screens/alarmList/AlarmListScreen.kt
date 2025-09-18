package com.tomildev.pillmate.ui.theme.screens.alarmList

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.tomildev.pillmate.R
import com.tomildev.pillmate.ui.theme.components.AlarmCard
import com.tomildev.pillmate.ui.theme.navigations.AppScreen
import com.tomildev.pillmate.ui.theme.theme.FontDarkPurple
import com.tomildev.pillmate.ui.theme.theme.FontDarkPurple2

data class Alarm(
    val medicineName: String,
    val remainingTime: String,
    val alarmTime: String,
    val repeatText: String,
    var isActive: Boolean
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlarmListScreen(
    navController: NavController,
    alarms: List<Alarm>,
    onAddClick: () -> Unit,
    onMenuClick: () -> Unit
) {
    var alarmList by remember { mutableStateOf(alarms) }

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.height(65.dp),
                title = {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        Text(
                            text = "PillMate",
                            color = FontDarkPurple2,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            modifier = Modifier.align(Alignment.Center)
                        )

                        IconButton(
                            onClick = { onMenuClick() },
                            modifier = Modifier.align(Alignment.CenterEnd)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.menu_icon),
                                contentDescription = "Menu",
                                tint = FontDarkPurple2
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(AppScreen.AlarmFormScreen.route)
                },
                containerColor = Color(0xFF9B8AFF),
                contentColor = Color.White,
                modifier = Modifier
                    .size(80.dp)
                    .offset(y = 30.dp),
                shape = CircleShape
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.plus_icon),
                    contentDescription = "Agregar alarma",
                    modifier = Modifier.size(40.dp)
                )
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = innerPadding.calculateTopPadding(),
                    start = 9.dp,
                    end = 9.dp
                )
        ) {
            Text(
                text = "Mis Alarmas",
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontSize = 38.sp,
                    fontWeight = FontWeight.Bold,
                    color = FontDarkPurple
                ),
                modifier = Modifier.padding(bottom = 12.dp, start = 4.dp)
            )

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(bottom = 4.dp)
            ) {
                items(alarmList) { alarm ->
                    AlarmCard(
                        medicineName = alarm.medicineName,
                        remainingTime = alarm.remainingTime,
                        alarmTime = alarm.alarmTime,
                        repeatText = alarm.repeatText,
                        isActive = alarm.isActive,
                        onToggle = { isChecked ->
                            alarmList = alarmList.map {
                                if (it == alarm) it.copy(isActive = isChecked) else it
                            }
                        }
                    )
                }
            }
        }
    }
}

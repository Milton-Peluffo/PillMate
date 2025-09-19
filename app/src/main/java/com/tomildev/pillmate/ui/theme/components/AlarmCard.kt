package com.tomildev.pillmate.ui.theme.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tomildev.pillmate.ui.theme.theme.FontDarkPurple2
import com.tomildev.pillmate.ui.theme.theme.FontDarkPurple3
import com.tomildev.pillmate.ui.theme.theme.ToggleButtonOutline2

@Composable
fun AlarmCard(
    medicineName: String,
    remainingTime: String,
    alarmTime: String,
    repeatText: String,
    isActive: Boolean,
    onToggle: (Boolean) -> Unit
) {
    Surface(
        shape = RoundedCornerShape(12.dp),
        tonalElevation = 1.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        color = Color(0xFFFDFDFE),
        border = BorderStroke(1.dp, ToggleButtonOutline2)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Column(
                modifier = Modifier.align(Alignment.CenterStart)
            ) {
                Text(
                    text = medicineName,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Bold,
                        color = FontDarkPurple2,
                        fontSize = 24.sp
                    )
                )

                Text(
                    text = "Tiempo restante: $remainingTime",
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = FontDarkPurple3,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                        ),
                    modifier = Modifier.padding(top = 2.dp, bottom = 1.dp)
                )

                Text(
                    text = alarmTime,
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontWeight = FontWeight.Medium,
                        fontSize = 35.sp,
                        color = FontDarkPurple3
                    ),
                    modifier = Modifier.padding(top = 2.dp, bottom = 1.dp)
                )

                Text(
                    text = repeatText,
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF3A345E),
                        fontSize = 15.sp
                    ),
                    modifier = Modifier.padding(top = 2.dp)
                )
            }

            Switch(
                checked = isActive,
                onCheckedChange = { onToggle(it) },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.White,
                    checkedTrackColor = Color(0xFF9B8AFF),
                    uncheckedThumbColor = Color.White,
                    uncheckedTrackColor = Color(0xFFCCCCCC)
                ),
                modifier = Modifier.align(Alignment.CenterEnd)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAlarmCard() {
    Column {
        AlarmCard(
            medicineName = "Sulfato de Albuterol",
            remainingTime = "3h 20m",
            alarmTime = "08:00 AM",
            repeatText = "Todos los días",
            isActive = true,
            onToggle = {}
        )
        AlarmCard(
            medicineName = "Sulfato de Albuterol",
            remainingTime = "3h 20m",
            alarmTime = "08:00 AM",
            repeatText = "Todos los días",
            isActive = false,
            onToggle = {}
        )
    }
}
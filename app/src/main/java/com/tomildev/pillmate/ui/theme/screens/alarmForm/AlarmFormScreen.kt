package com.tomildev.pillmate.ui.theme.screens.alarmForm

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.tomildev.pillmate.R
import com.tomildev.pillmate.ui.theme.theme.FontDarkPurple
import com.tomildev.pillmate.ui.theme.components.InputField
import com.tomildev.pillmate.ui.theme.components.DayToggleButton
import com.tomildev.pillmate.ui.theme.components.BackButton
import com.tomildev.pillmate.ui.theme.navigations.AppScreen
import com.tomildev.pillmate.ui.theme.theme.ButtonPurple
import com.tomildev.pillmate.ui.theme.theme.FontDarkPurple2
import com.tomildev.pillmate.ui.theme.theme.FontSoftPurple

@Composable
fun AlarmFormScreen(
    navController: NavController,
    onBack: () -> Unit = {},
    onSave: () -> Unit = {},
    onCancel: () -> Unit = {}
) {
    var medicineName by remember { mutableStateOf("") }
    var medicineQuantity by remember { mutableStateOf("") }
    var medicineHour by remember { mutableStateOf("") }
    var repeatHours by remember { mutableStateOf("") }
    var selectedDays by remember { mutableStateOf(setOf<String>()) }

    val days = listOf("Lun", "Mar", "Mie", "Jue", "Vie", "Sab", "Dom")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        BackButton(
            onClick = {
                navController.navigate(AppScreen.AlarmListScreen.route)
            },
            iconRes = R.drawable.arrow_left,
            contentDescription = "Atrás",
        )

        Text(
            text = "Agregar Alarma",
            fontSize = 38.sp,
            fontWeight = FontWeight.Bold,
            color = FontDarkPurple
        )

        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Nombre de la medicina",
            fontSize = 19.sp,
            fontWeight = FontWeight.Bold,
            color = FontDarkPurple2
        )

        InputField(
            placeholder = "Ej: Aspirina",
            value = medicineName,
            onValueChange = { medicineName = it },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.pill_icon),
                    contentDescription = "Medicamento",
                    tint = FontDarkPurple
                )
            }
        )

        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Cantidad",
            fontSize = 19.sp,
            fontWeight = FontWeight.Bold,
            color = FontDarkPurple
        )
        InputField(
            placeholder = "Ej: 2 pastillas de 200mg",
            value = medicineQuantity,
            onValueChange = { medicineQuantity = it },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.pills_quantity),
                    contentDescription = "cantidad",
                    tint = FontDarkPurple
                )
            }
        )

        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Hora",
            fontSize = 19.sp,
            fontWeight = FontWeight.Bold,
            color = FontDarkPurple
        )
        InputField(
            placeholder = "Seleccionar",
            value = medicineHour,
            onValueChange = { medicineHour = it },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.clock),
                    contentDescription = "Hora",
                    tint = FontDarkPurple
                )
            }
        )

        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Repetir",
            fontSize = 19.sp,
            fontWeight = FontWeight.Bold,
            color = FontDarkPurple
        )
        Row(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
            days.forEach { day ->
                val isSelected = selectedDays.contains(day)
                DayToggleButton(
                    day = day,
                    isSelected = isSelected,
                    onClick = {
                        selectedDays = if (isSelected) {
                            selectedDays - day
                        } else {
                            selectedDays + day
                        }
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "¿Cada cuántas horas se repite?",
            fontWeight = FontWeight.Bold,
            fontSize = 19.sp,
            color = FontDarkPurple
        )
        Text(
            text = "(opcional)",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = FontSoftPurple
        )
        InputField(
            placeholder = "Seleccionar",
            value = repeatHours,
            onValueChange = { repeatHours = it },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.stopwatch),
                    contentDescription = "Repetición",
                    tint = FontDarkPurple
                )
            }
        )

        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = onSave,
            modifier = Modifier.fillMaxWidth().height(50.dp),
            shape = RoundedCornerShape(19.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = ButtonPurple
            )
        ) {
            Text(
                text = "Guardar Alarma",
                fontSize = 19.sp,
                color = MaterialTheme.colorScheme.onPrimary,
                fontWeight = FontWeight.Bold
            )
        }
//
//        TextButton(
//            onClick = onCancel,
//            modifier = Modifier.fillMaxWidth().height(50.dp),
//            shape = RoundedCornerShape(19.dp)
//            ) {
//            Text(
//                text = "Cancelar",
//                fontSize = 19.sp,
//                color = FontDarkPurple,
//                fontWeight = FontWeight.Bold
//            )
//        }
    }
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun AlarmFormScreenPreview() {
//    AlarmFormScreen()
//}
package com.tomildev.pillmate.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tomildev.pillmate.ui.theme.theme.FontDarkPurple
import com.tomildev.pillmate.ui.theme.theme.ToggleButtonBackground
import com.tomildev.pillmate.ui.theme.theme.ButtonPurple
import com.tomildev.pillmate.ui.theme.theme.ToggleButtonOutline

@Composable
fun DayToggleButton(
    day: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val shape = RoundedCornerShape(8.dp)

    Box(
        modifier = Modifier
            .size(50.dp)
            .background(
                color = if (isSelected) ButtonPurple else ToggleButtonBackground,
                shape = shape
            )
            .then(
                if (isSelected) Modifier.border(2.dp, ToggleButtonOutline, shape)
                else Modifier
            )
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = day,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = if (isSelected) Color.White else FontDarkPurple
        )
    }
}

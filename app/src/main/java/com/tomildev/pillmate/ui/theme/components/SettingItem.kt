package com.tomildev.pillmate.ui.theme.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tomildev.pillmate.R
import com.tomildev.pillmate.ui.theme.theme.FontDarkPurple2

@Composable
fun SettingItem(
    title: String,
    icon: Painter? = null,
    value: String? = null,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp)
            .height(60.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = title,
                color = FontDarkPurple2,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            if (value != null) {
                Text(
                    text = value,
                    color = FontDarkPurple2,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal
                )
            } else if (icon != null) {
                Icon(
                    painter = icon,
                    contentDescription = null,
                    tint = FontDarkPurple2,
                    modifier = Modifier.size(40.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SettingItemPreview() {
    ColumnPreview()
}

@Composable
fun ColumnPreview() {
    androidx.compose.foundation.layout.Column {
        SettingItem(
            title = "Tema de la app",
            icon = painterResource(id = R.drawable.sun_icon),
            onClick = {}
        )
        SettingItem(
            title = "Lenguaje",
            value = "Español",
            onClick = {}
        )
    }
}
package com.tomildev.pillmate.ui.theme.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tomildev.pillmate.R
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.remember

@Composable
fun BackButton(
    iconRes: Int,
    contentDescription: String?,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    iconSize: Dp = 34.dp
) {
    Surface(
        modifier = modifier.size(48.dp),
        color = Color.Transparent,
        shape = RoundedCornerShape(16.dp),
    ) {
        Box(
            modifier = Modifier
                .clickable(
                    onClick = onClick,
                    indication = null, // 🔑 elimina el ripple
                    interactionSource = remember { MutableInteractionSource() } // necesario para quitar efectos
                )
        ) {
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = contentDescription,
                modifier = Modifier.size(iconSize)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BackButtonPreview() {
    BackButton(
        iconRes = R.drawable.arrow_left,
        contentDescription = "Atrás",
        onClick = { },
        iconSize = 28.dp
    )
}

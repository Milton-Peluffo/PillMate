package com.tomildev.pillmate.ui.theme.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tomildev.pillmate.ui.theme.theme.InputBorderUnfocused
import com.tomildev.pillmate.ui.theme.theme.InputBorderfocused
import com.tomildev.pillmate.ui.theme.theme.InputPlaceHolder

@Composable
fun InputField(
    placeholder: String = "",
    value: String,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                text = placeholder,
                color = InputPlaceHolder
            )
        },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = InputBorderfocused,
            unfocusedBorderColor = InputBorderUnfocused
        )
    )
}

@Preview(showBackground = true)
@Composable
fun InputFieldPreview() {
    var text by remember { mutableStateOf("") }

    InputField(
        placeholder = "Ej: Aspirina",
        value = text,
        onValueChange = { text = it }
    )

}
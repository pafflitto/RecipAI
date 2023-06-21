package com.example.ui.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun AlertDialogWithNavColor(
    text: @Composable () -> Unit,
    confirmButton: String,
    onDismissRequest: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        confirmButton = {
            TextButton(
                onClick = onDismissRequest
            ) {
                Text(confirmButton)
            }
        },
        text = {
            val uiController = rememberSystemUiController()
            SideEffect {
                uiController.setNavigationBarColor(Color.Transparent)
            }
            text()
        }
    )
}

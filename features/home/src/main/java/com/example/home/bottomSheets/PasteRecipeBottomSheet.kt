package com.example.home.bottomSheets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Link
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.hapticfeedback.HapticFeedback
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.ui.components.AlertDialogWithNavColor
import com.example.ui.components.BottomSheetPrimaryButton
import com.features.home.R
import kotlinx.coroutines.delay
import kotlinx.datetime.LocalDate

@Composable
fun PasteRecipeBottomSheet(
    date: LocalDate,
    closeBottomSheet: () -> Unit,
    generateLink: (text: String, date: LocalDate) -> Unit
) {
    val clipManager = LocalClipboardManager.current
    val text = clipManager.getText()?.text

    VibrateLaunchedEffect(
        hapticManager = LocalHapticFeedback.current,
        hasText = text != null
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (text != null) {
            var showDialog by remember { mutableStateOf(false) }
            if (showDialog) {
                AlertDialogWithNavColor(
                    confirmButton = stringResource(id = R.string.close),
                    onDismissRequest = { showDialog = false },
                    text = {
                        Text(
                            modifier = Modifier.verticalScroll(
                                state = rememberScrollState()
                            ),
                            text = text
                        )
                    }
                )
            }
            TextButton(
                onClick = { showDialog = true }
            ) {
                Text(
                    text = stringResource(id = R.string.view_copied_recipe),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            BottomSheetPrimaryButton(
                text = stringResource(id = R.string.generate),
                icon = Icons.Rounded.Link,
                onClick = {
                    generateLink(text, date)
                }
            )
        }
    }
}

@Composable
private fun VibrateLaunchedEffect(
    hapticManager: HapticFeedback,
    hasText: Boolean
) = LaunchedEffect(Unit) {
    if (!hasText) {
        hapticManager.performHapticFeedback(
            HapticFeedbackType.LongPress
        )
        delay(100)
        hapticManager.performHapticFeedback(
            HapticFeedbackType.LongPress
        )
    } else {
        hapticManager.performHapticFeedback(
            HapticFeedbackType.LongPress
        )
    }
}

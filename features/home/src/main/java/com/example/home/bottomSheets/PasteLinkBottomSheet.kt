package com.example.home.bottomSheets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Link
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.hapticfeedback.HapticFeedback
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.ui.components.ScrollingText
import com.features.home.R
import kotlinx.coroutines.delay

@Composable
fun PasteLinkBottomSheet(
    dayIndex: Int,
    closeBottomSheet: () -> Unit,
    generateLink: (url: String, dayIndex: Int) -> Unit
) {
    val clipManager = LocalClipboardManager.current
    val scope = rememberCoroutineScope()
    val url = clipManager.getText()?.text

    VibrateLaunchedEffect(
        hapticManager = LocalHapticFeedback.current,
        hasText = url != null
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, bottom = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (url != null) {
            ScrollingText(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
                text = url,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(16.dp))
            FilledTonalButton(
                shape = RoundedCornerShape(16.dp),
                border = BorderStroke(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.secondary
                ),
                colors = ButtonDefaults.filledTonalButtonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                ),
                onClick = {
                    generateLink(url, dayIndex)
                }
            ) {
                Icon(
                    imageVector = Icons.Rounded.Link,
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = stringResource(id = R.string.generate)
                )
            }
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

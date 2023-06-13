package com.example.ui.components

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput

fun Modifier.bounceClick(
    onClick: () -> Unit
): Modifier = composed {
    var pressed by remember { mutableStateOf(false) }
    val transition = updateTransition(pressed, label = "Scaling Text")
    val animatedScale by transition.animateFloat(
        transitionSpec = { tween(durationMillis = 400) },
        label = ""
    ) { if (it) 0.8f else 1f }

    val alpha by transition.animateFloat(label = "animated transparency") {
        if (it) 0.7f else 1f
    }

    graphicsLayer(
        scaleX = animatedScale,
        scaleY = animatedScale
    ).alpha(alpha).clickable(
        interactionSource = remember { MutableInteractionSource() },
        indication = null,
        onClick = onClick
    ).pointerInput(pressed) {
        awaitPointerEventScope {
            pressed = if (pressed) {
                waitForUpOrCancellation()
                false
            } else {
                awaitFirstDown(false)
                true
            }
        }
    }
}

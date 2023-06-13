package com.example.ui.components

import androidx.compose.foundation.Indication
import androidx.compose.foundation.IndicationInstance
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.drawscope.ContentDrawScope

class PressedIndication(
    val pressedChanged: (Boolean) -> Unit
) : Indication {

    private inner class PressedIndication(
        private val isPressed: State<Boolean>,
    ) : IndicationInstance {

        override fun ContentDrawScope.drawIndication() {
            drawContent()
            pressedChanged(isPressed.value)
        }
    }

    @Composable
    override fun rememberUpdatedInstance(interactionSource: InteractionSource): IndicationInstance {
        val isPressed = interactionSource.collectIsPressedAsState()
        return remember(interactionSource) {
            PressedIndication(isPressed)
        }
    }
}

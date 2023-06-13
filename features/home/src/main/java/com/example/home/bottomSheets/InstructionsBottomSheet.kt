package com.example.home.bottomSheets

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun InstructionsBottomSheet(
    state: BottomSheetContent.Instructions
) {
    val listState = rememberLazyListState()
    val firstVisibleItemIndex = remember { derivedStateOf { listState.firstVisibleItemIndex } }
    val completedInstructions = remember {
        List(state.instructions.size) { mutableStateOf(false) }
    }
    val scope = rememberCoroutineScope()

    fun toggleIndex(index: Int) {
        val newValue = !completedInstructions[index].value
        completedInstructions[index].value = newValue
        if (newValue) {
            scope.launch {
                delay(200)
                listState.animateScrollToItem(index + 1)
            }
        }
    }

    LazyColumn(
        state = listState,
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        itemsIndexed(state.instructions) { index, instructionItem ->
            val checked by completedInstructions[index]
            val transition = updateTransition(
                targetState = checked,
                label = "Instruction Completed Transition"
            )
            val textColor by transition.animateColor(
                label = "Instruction Text Color"
            ) {
                if (it) {
                    MaterialTheme.colorScheme.onSurface.copy(0.7f)
                } else {
                    MaterialTheme.colorScheme.onSurface
                }
            }

            val backgroundColor by transition.animateColor(
                label = "Background Color"
            ) {
                if (it) {
                    MaterialTheme.colorScheme.surface.copy(0.5f)
                } else {
                    MaterialTheme.colorScheme.surface
                }
            }

            var scale by remember { mutableStateOf(1f) }

            LaunchedEffect(firstVisibleItemIndex) {
                snapshotFlow { listState.firstVisibleItemScrollOffset }.collect {
                    if (firstVisibleItemIndex.value == index) {
                        scale = 1f - (0.0005f * it)
                    }
                }
            }

            val scaleAnimated by animateFloatAsState(targetValue = scale)

            Row(
                modifier = Modifier
                    .scale(scaleAnimated)
                    .clip(RoundedCornerShape(16.dp))
                    .clickable {
                        toggleIndex(index)
                    }
                    .background(backgroundColor)
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .alignByBaseline(),
                    text = instructionItem,
                    style = MaterialTheme.typography.bodyLarge,
                    color = textColor
                )
            }
        }
    }
}

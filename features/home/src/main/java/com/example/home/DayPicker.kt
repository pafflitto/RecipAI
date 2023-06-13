package com.example.home

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onPlaced
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.dp
import kotlinx.datetime.LocalDate
import java.time.format.TextStyle
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DayPicker(
    state: DashboardViewState.Loaded,
    listState: LazyListState,
    selectedIndex: Int,
    itemWidths: SnapshotStateList<Int>,
    moveItemToCenter: (Int, Int) -> Unit
) {
    LazyRow(
        state = listState,
        contentPadding = PaddingValues(vertical = 16.dp, horizontal = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.onPlaced {
            it.size.height
        }
    ) {
        itemsIndexed(state.cuisines) { index, cuisineForDay ->
            val transition = updateTransition(
                targetState = index == selectedIndex,
                label = "Selected Transition"
            )

            val filledInDayColor by transition.animateColor(
                transitionSpec = { tween(durationMillis = 400, delayMillis = 200) },
                label = "Day Background Color"
            ) {
                if (it) {
                    MaterialTheme.colorScheme.inverseSurface
                } else {
                    Color.Transparent
                }
            }

            val dayTextColor by transition.animateColor(
                transitionSpec = { tween(durationMillis = 400, delayMillis = 200) },
                label = "Day Text Color"
            ) {
                if (it) {
                    MaterialTheme.colorScheme.inverseOnSurface
                } else {
                    MaterialTheme.colorScheme.onSurface
                }
            }

            val (date, cuisine) = cuisineForDay
            OutlinedCard(
                shape = CircleShape,
                modifier = Modifier
                    .onSizeChanged {
                        itemWidths[index] = it.width
                    },
                colors = CardDefaults.outlinedCardColors(
                    containerColor = filledInDayColor
                ),
                onClick = {
                    moveItemToCenter(index, itemWidths[index])
                }
            ) {
                Row(
                    modifier = Modifier.height(IntrinsicSize.Min),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                        text = date.pickerText,
                        color = dayTextColor
                    )
                    cuisine?.let { cuisine ->
                        Text(
                            text = cuisine,
                            modifier = Modifier
                                .shadow(
                                    elevation = 16.dp,
                                    shape = CircleShape
                                )
                                .background(
                                    color = MaterialTheme.colorScheme.primary,
                                    shape = CircleShape
                                )
                                .padding(horizontal = 8.dp, vertical = 4.dp),
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                    } ?: Box(Modifier.padding(start = 4.dp, end = 8.dp)) {
                        Icon(
                            imageVector = Icons.Rounded.Add,
                            contentDescription = "Add Recipe",
                            tint = dayTextColor
                        )
                    }
                }
            }
        }
    }
}

private val LocalDate.pickerText get() = "${dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.getDefault())} $dayOfMonth"

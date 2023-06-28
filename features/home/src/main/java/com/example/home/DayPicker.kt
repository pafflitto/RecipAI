package com.example.home

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import kotlinx.datetime.LocalDate
import java.time.format.TextStyle
import java.util.Locale

data class DayLayoutInfo(
    val width: Int,
    val position: Int
) {
    companion object {
        val None = DayLayoutInfo(0, 0)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DayPicker(
    state: DashboardViewState.Loaded,
    listState: LazyListState,
    selectedIndex: Int,
    itemLayoutInfo: SnapshotStateList<DayLayoutInfo>,
    moveItemToCenter: (Int) -> Unit
) {
    val density = LocalDensity.current
    val halfScreenWidth = LocalConfiguration.current.screenWidthDp.dp / 2
    LazyRow(
        state = listState,
        contentPadding = PaddingValues(
            start = halfScreenWidth - with(density) {
                itemLayoutInfo.first().width.toDp()
            },
            top = 16.dp,
            end = halfScreenWidth - with(density) {
                itemLayoutInfo.last().width.toDp()
            },
            bottom = 16.dp
        ),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
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

            val outlineColor by transition.animateColor(
                transitionSpec = { tween(durationMillis = 400, delayMillis = 200) },
                label = "Day Outline Color"
            ) {
                if (it) Color.Transparent else MaterialTheme.colorScheme.outline
            }

            val (date, cuisine) = cuisineForDay
            OutlinedCard(
                shape = CircleShape,
                modifier = Modifier.onPlaced {
                    if (itemLayoutInfo[index] == DayLayoutInfo.None) {
                        itemLayoutInfo[index] = DayLayoutInfo(
                            width = it.size.width / 2,
                            position = (it.positionInParent().x + it.size.width / 2).toInt()
                        )
                    }
                },
                colors = CardDefaults.outlinedCardColors(
                    containerColor = filledInDayColor,

                ),
                border = BorderStroke(1.dp, outlineColor),
                onClick = {
                    moveItemToCenter(index)
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

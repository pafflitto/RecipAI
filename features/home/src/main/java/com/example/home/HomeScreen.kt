package com.example.home

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.with
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.home.bottomSheets.BottomSheetContentState
import kotlin.math.abs

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    openBottomSheet: () -> Unit,
    closeBottomSheet: () -> Unit
) {
    AnimatedContent(
        targetState = viewModel.dashboardState,
        transitionSpec = { fadeIn() with fadeOut() }
    ) { targetState ->
        when (targetState) {
            is DashboardViewState.Loading -> { }
            is DashboardViewState.Loaded -> {
                RecipeSection(
                    state = targetState,
                    toggleIngredientStock = viewModel::toggleIngredientInPantry,
                    setBottomSheetContent = viewModel::setBottomSheetState,
                    openBottomSheet = openBottomSheet,
                    closeBottomSheet = closeBottomSheet
                )
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RecipeSection(
    state: DashboardViewState.Loaded,
    toggleIngredientStock: (UpdateIngredientParams) -> Unit,
    setBottomSheetContent: (BottomSheetContentState) -> Unit,
    openBottomSheet: () -> Unit,
    closeBottomSheet: () -> Unit
) {
    val itemLayoutInfo = remember {
        List(7) { DayLayoutInfo.None }.toMutableStateList()
    }
    val listState = rememberLazyListState(state.todaysIndex)
    var selectedIndex by remember { mutableStateOf(state.todaysIndex) }
    val pagerState = rememberPagerState(selectedIndex)
    val pagerDragged by pagerState.interactionSource.collectIsDraggedAsState()

    LaunchedEffect(pagerDragged) {
        var totalAmountScrolled = 0f
        snapshotFlow {
            pagerState.calculateCurrentOffsetForPage(pagerState.settledPage)
        }.collect {
            val itemScrollingTo = when {
                pagerState.settledPage == 0 && it < 0 -> 0
                pagerState.settledPage == 6 && it > 0 -> 6
                it > 0 -> pagerState.settledPage + 1
                else -> pagerState.settledPage - 1
            }
            when {
                pagerDragged -> {
                    val distanceToItem =
                        itemLayoutInfo[itemScrollingTo].position - itemLayoutInfo[pagerState.settledPage].position
                    val scrollAmount = (abs(it) * distanceToItem) - totalAmountScrolled
                    listState.scrollBy(scrollAmount)
                    totalAmountScrolled += scrollAmount
                }
                selectedIndex != pagerState.settledPage -> {
                    // Day clicked on
                    listState.animateScrollToItem(selectedIndex)
                }
                pagerState.settledPage != pagerState.targetPage -> {
                    // Finished drag
                    listState.animateScrollToItem(pagerState.targetPage)
                }
            }
        }
    }

    Column {
        DayPicker(
            state = state,
            listState = listState,
            selectedIndex = selectedIndex,
            itemLayoutInfo = itemLayoutInfo,
            moveItemToCenter = { index ->
                selectedIndex = index
            }
        )
        RecipePager(
            modifier = Modifier.weight(1f),
            dashboardState = state,
            pagerState = pagerState,
            selectedPage = selectedIndex,
            toggleIngredientStock = toggleIngredientStock,
            pageChange = {
                selectedIndex = it
                closeBottomSheet()
            },
            openBottomSheet = openBottomSheet,
            setBottomSheetContent = setBottomSheetContent
        )
    }
}

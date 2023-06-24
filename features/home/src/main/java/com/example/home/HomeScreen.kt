package com.example.home

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.with
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.home.bottomSheets.BottomSheetContentState
import kotlinx.coroutines.launch

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

@Composable
fun RecipeSection(
    state: DashboardViewState.Loaded,
    toggleIngredientStock: (UpdateIngredientParams) -> Unit,
    setBottomSheetContent: (BottomSheetContentState) -> Unit,
    openBottomSheet: () -> Unit,
    closeBottomSheet: () -> Unit
) {
    val itemWidths = remember { mutableStateListOf(0, 0, 0, 0, 0, 0, 0) }
    val listState = rememberLazyListState(state.todaysIndex)
    var selectedIndex by remember { mutableStateOf(state.todaysIndex) }
    val density = LocalDensity.current
    val centerOffset = with(density) {
        -LocalConfiguration.current.screenWidthDp.dp.roundToPx() / 2
    }
    val scope = rememberCoroutineScope()

    fun moveItemToCenter(index: Int, itemWidth: Int) = scope.launch {
        selectedIndex = index
        listState.animateScrollToItem(selectedIndex, centerOffset + itemWidth / 2)
    }

    Column {
        DayPicker(
            state = state,
            listState = listState,
            selectedIndex = selectedIndex,
            itemWidths = itemWidths,
            moveItemToCenter = { index, itemWidth ->
                moveItemToCenter(index, itemWidth)
            }
        )
        RecipePager(
            modifier = Modifier
                .weight(1f),
            dashboardState = state,
            selectedPage = selectedIndex,
            toggleIngredientStock = toggleIngredientStock,
            pageChange = {
                closeBottomSheet()
                moveItemToCenter(it, itemWidths[it])
            },
            openBottomSheet = openBottomSheet,
            setBottomSheetContent = setBottomSheetContent
        )
    }
}

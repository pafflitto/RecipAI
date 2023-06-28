package com.example.home

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.core.data.Recipe
import com.example.home.bottomSheets.BottomSheetContentState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.datetime.LocalDate

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RecipePager(
    dashboardState: DashboardViewState.Loaded,
    pagerState: PagerState,
    modifier: Modifier,
    selectedPage: Int,
    toggleIngredientStock: (UpdateIngredientParams) -> Unit,
    pageChange: (Int) -> Unit,
    openBottomSheet: () -> Unit,
    setBottomSheetContent: (BottomSheetContentState) -> Unit

) {
    val recipesForWeek = dashboardState.recipesForWeek
    val scope = rememberCoroutineScope()

    LaunchedEffect(selectedPage) {
        if (selectedPage != pagerState.currentPage) {
            pagerState.animateScrollToPage(selectedPage)
        }
    }

    LaunchedEffect(Unit) {
        snapshotFlow { pagerState.settledPage }.collect {
            pageChange(it)
            launch {
                val recipeForDay = recipesForWeek[it]
                recipeForDay.recipe?.let { recipe ->
                    setBottomSheetContent(BottomSheetContentState.Instructions(recipe.instructions))
                } ?: setBottomSheetContent(BottomSheetContentState.None)
            }
        }
    }

    HorizontalPager(
        modifier = modifier,
        state = pagerState,
        pageCount = recipesForWeek.size,
        pageSpacing = 16.dp,
        beyondBoundsPageCount = 1
    ) { page ->
        val recipeForDay = recipesForWeek[page]
        val pageOffset = pagerState.calculateCurrentOffsetForPage(page)
        val recipe = recipeForDay.recipe
        if (recipe != null) {
            RecipePage(
                selected = selectedPage == page,
                pageOffset = pageOffset,
                recipe = recipe,
                toggleRecipeInStock = {
                    toggleIngredientStock(
                        UpdateIngredientParams(page, it)
                    )
                },
                showInstructions = openBottomSheet
            )
        } else {
            AddRecipeCard(
                date = recipeForDay.date,
                selected = selectedPage == page,
                openBottomSheet = {
                    scope.launch {
                        setBottomSheetContent(it)
                        delay(100)
                        openBottomSheet()
                    }
                }
            )
        }
    }
}

@Composable
fun PageHeader(
    selected: Boolean,
    title: String
) {
    val textColor by animateColorAsState(
        targetValue = if (selected) {
            MaterialTheme.colorScheme.primary
        } else {
            MaterialTheme.colorScheme.onSurfaceVariant
        },
        animationSpec = tween(durationMillis = 400, delayMillis = 200)
    )
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        text = title,
        style = MaterialTheme.typography.titleLarge,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
        color = textColor
    )
}

@OptIn(ExperimentalFoundationApi::class)
fun PagerState.calculateCurrentOffsetForPage(page: Int): Float {
    return (currentPage - page) + currentPageOffsetFraction
}

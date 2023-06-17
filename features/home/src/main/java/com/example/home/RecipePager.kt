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
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.home.bottomSheets.BottomSheetContentState
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RecipePager(
    modifier: Modifier,
    selectedPage: Int,
    recipesForWeek: List<RecipeForDay>,
    toggleIngredientStock: (UpdateIngredientParams) -> Unit,
    pageChange: (Int) -> Unit,
    openBottomSheet: () -> Unit,
    setBottomSheetContent: (BottomSheetContentState) -> Unit

) {
    val state = rememberPagerState(selectedPage)

    LaunchedEffect(selectedPage) {
        if (selectedPage != state.currentPage) {
            state.animateScrollToPage(selectedPage)
        }
    }

    LaunchedEffect(Unit) {
        snapshotFlow { state.settledPage }.collect {
            pageChange(it)
            launch {
                val recipeForDay = recipesForWeek[it]
                recipeForDay.recipe?.let { recipe ->
                    setBottomSheetContent(BottomSheetContentState.Instructions(recipe.instructions))
                } ?: setBottomSheetContent(BottomSheetContentState.Loading)
            }
        }
    }

    HorizontalPager(
        modifier = modifier,
        state = state,
        pageCount = recipesForWeek.size,
        pageSpacing = 16.dp,
        beyondBoundsPageCount = 1
    ) { page ->
        val recipeState = recipesForWeek[page]
        val pageOffset = state.calculateCurrentOffsetForPage(page)
        if (recipeState.recipe != null) {
            RecipePage(
                selected = selectedPage == page,
                pageOffset = pageOffset,
                recipe = recipeState.recipe,
                toggleRecipeInStock = {
                    toggleIngredientStock(
                        UpdateIngredientParams(page, it)
                    )
                },
                showInstructions = openBottomSheet
            )
        } else {
            AddRecipeCard(
                date = recipeState.date,
                selected = selectedPage == page,
                openBottomSheet = {
                    setBottomSheetContent(it)
                    openBottomSheet()
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

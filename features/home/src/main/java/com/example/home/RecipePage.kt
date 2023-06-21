package com.example.home

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Summarize
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.core.data.Ingredient
import com.example.core.data.Recipe
import com.features.home.R
import kotlin.math.absoluteValue

@Composable
fun RecipePage(
    selected: Boolean,
    pageOffset: Float,
    recipe: Recipe,
    toggleRecipeInStock: (Int) -> Unit,
    showInstructions: () -> Unit
) {
    val animatedOffset by animateFloatAsState(targetValue = pageOffset)

    Column(
        Modifier.offset(y = (LocalConfiguration.current.screenHeightDp.dp / 5) * animatedOffset.absoluteValue)
    ) {
        PageHeader(
            selected = selected,
            title = recipe.name
        )
        InteractionCards(
            pageOffset = pageOffset,
            recipe = recipe,
            modifier = Modifier.weight(1f),
            toggleRecipeInStock = toggleRecipeInStock,
            showInstructions = showInstructions
        )
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun InteractionCards(
    pageOffset: Float,
    recipe: Recipe,
    modifier: Modifier,
    toggleRecipeInStock: (Int) -> Unit,
    showInstructions: () -> Unit
) {
    var instructionsButtonHeight by remember { mutableStateOf(0.dp) }
    val density = LocalDensity.current

    IngredientCard(
        modifier = modifier.fillMaxWidth(),
        title = stringResource(id = R.string.ingredients),
        cookTime = recipe.cookTimeMinutes,
        prepTime = recipe.prepTimeMinutes,
        servings = recipe.servings,
        alpha = 1 - (pageOffset.absoluteValue * 1.7f),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 8.dp
        )
    ) {
        FlowRow(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .verticalScroll(state = rememberScrollState())
                .fillMaxSize(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            recipe.ingredients.forEachIndexed { index, ingredient ->
                IngredientChip(ingredient = ingredient) {
                    toggleRecipeInStock(index)
                }
            }
            Spacer(
                modifier = Modifier
                    .weight(1f)
                    .height(instructionsButtonHeight)
            )
        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .onSizeChanged {
                    instructionsButtonHeight = with(density) { it.height.toDp() + 32.dp }
                }
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            MaterialTheme.colorScheme.surfaceVariant
                        )
                    )
                )
                .fillMaxWidth()
                .padding(bottom = 16.dp, top = 40.dp)
        ) {
            FilledTonalButton(
                colors = ButtonDefaults.filledTonalButtonColors(
                    containerColor = MaterialTheme.colorScheme.inverseSurface
                ),
                modifier = Modifier.align(Alignment.Center),
                onClick = showInstructions
            ) {
                Icon(
                    imageVector = Icons.Rounded.Summarize,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSecondary
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = stringResource(id = R.string.instructions),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSecondary
                )
            }
        }
    }
}

@Composable
private fun IngredientCard(
    modifier: Modifier = Modifier,
    elevation: CardElevation = CardDefaults.cardElevation(0.dp),
    title: String,
    prepTime: Int,
    cookTime: Int,
    servings: Int,
    alpha: Float = 1f,
    titleHeight: (Int) -> Unit = { },
    content: @Composable BoxScope.() -> Unit = { }
) {
    ElevatedCard(
        modifier = modifier,
        elevation = elevation,
        shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(Modifier.alpha(alpha)) {
            val detailsPillModifier = Modifier
                .background(
                    color = MaterialTheme.colorScheme.surface,
                    shape = CircleShape
                )
                .padding(8.dp)
            Row(
                modifier = Modifier
                    .padding(16.dp),
                Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    modifier = detailsPillModifier,
                    text = stringResource(id = R.string.prep_time, prepTime)
                )
                Text(
                    modifier = detailsPillModifier,
                    text = stringResource(id = R.string.cook_time, cookTime)
                )
                Row(detailsPillModifier) {
                    Icon(
                        imageVector = Icons.Rounded.Person,
                        contentDescription = null
                    )
                    Text(servings.toString())
                }
            }
            Text(
                text = title,
                modifier = Modifier
                    .onSizeChanged { titleHeight(it.height) }
                    .padding(bottom = 8.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight.Bold
            )
            Box(
                Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                content()
            }
        }
    }
}

@Composable
private fun IngredientChip(
    ingredient: Ingredient,
    onClick: () -> Unit
) {
    val transition = updateTransition(
        label = "Ingredient Stocked Transition",
        targetState = ingredient.inPantry.value
    )

    val backgroundColor by transition.animateColor(
        label = "Ingredient Chip Background Color",
        transitionSpec = { tween(durationMillis = 400) }
    ) {
        if (it) MaterialTheme.colorScheme.primary else Color.Transparent
    }

    val textColor by transition.animateColor(
        label = "Ingredient Chip Text Color",
        transitionSpec = { tween(durationMillis = 400) }
    ) {
        if (it) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurface
    }
    Text(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .clip(RoundedCornerShape(8.dp))
            .clickable(onClick = onClick)
            .border(
                width = if (ingredient.inPantry.value) 0.dp else 1.dp,
                color = MaterialTheme.colorScheme.onSurface,
                shape = RoundedCornerShape(8.dp)
            )
            .background(backgroundColor)
            .padding(8.dp),
        text = ingredient.description,
        color = textColor,
        style = MaterialTheme.typography.bodyLarge
    )
}

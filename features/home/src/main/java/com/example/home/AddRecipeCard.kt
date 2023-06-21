package com.example.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ContentPaste
import androidx.compose.material.icons.rounded.TipsAndUpdates
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.home.bottomSheets.BottomSheetContentState
import com.example.ui.components.bounceClick
import com.features.home.R
import kotlinx.datetime.LocalDate

@Composable
fun AddRecipeCard(
    date: LocalDate,
    selected: Boolean,
    openBottomSheet: (BottomSheetContentState) -> Unit = { }
) {
    Column {
        PageHeader(
            selected = selected,
            title = stringResource(id = R.string.add_recipe)
        )

        Column(
            modifier = Modifier
                .padding(start = 32.dp, top = 40.dp, 32.dp)
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Row(
                modifier = Modifier
                    .weight(1f),
                horizontalArrangement = Arrangement.spacedBy(48.dp)
            ) {
                PasteLinkButton(
                    modifier = buttonModifier,
                    date = date,
                    openBottomSheet = openBottomSheet
                )
                CreatePromptButton(
                    modifier = buttonModifier,
                    date = date
                )
            }
            Row(
                modifier = Modifier
                    .weight(1f)
            ) {
                // TODO
            }
        }
    }
}

@Composable
private fun PasteLinkButton(
    modifier: Modifier,
    date: LocalDate,
    openBottomSheet: (BottomSheetContentState) -> Unit = { }
) = GenerateRecipeButton(
    modifier = modifier,
    title = stringResource(id = R.string.paste_recipe),
    icon = Icons.Rounded.ContentPaste
) {
    openBottomSheet(BottomSheetContentState.RecipeGenerationEntry.PasteLink(date))
}

@Composable
private fun CreatePromptButton(
    modifier: Modifier,
    date: LocalDate,
    openBottomSheet: (BottomSheetContentState) -> Unit = { }
) = GenerateRecipeButton(
    modifier = modifier,
    title = stringResource(id = R.string.create_a_prompt),
    icon = Icons.Rounded.TipsAndUpdates
) {
    // TODO
}

@Composable
private fun GenerateRecipeButton(
    modifier: Modifier,
    title: String,
    icon: ImageVector,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier
            .bounceClick(onClick)
            .clip(RoundedCornerShape(24.dp))
            .background(
                color = MaterialTheme.colorScheme.secondaryContainer
            )
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            modifier = Modifier.size(32.dp),
            imageVector = icon,
            contentDescription = null
        )
        Spacer(Modifier.height(16.dp))
        Text(
            modifier = Modifier.weight(1f),
            text = title,
            style = MaterialTheme.typography.titleMedium
        )
    }
}

private val RowScope.buttonModifier get() = Modifier
    .weight(1f)
    .aspectRatio(1f)

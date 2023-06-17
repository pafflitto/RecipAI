package com.example.home.bottomSheets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.core.data.Recipe
import com.example.ui.components.BottomSheetPrimaryButton
import com.example.ui.components.ScrollingText
import com.features.home.R

@Composable
fun PendingRecipeScreen(
    recipe: Recipe,
    closeBottomSheet: (Recipe) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ScrollingText(
            modifier = Modifier.fillMaxWidth(),
            text = recipe.name,
            color = MaterialTheme.colorScheme.primary
        )
        // TODO Recipe Overview
        Spacer(modifier = Modifier.weight(1f))

        BottomSheetPrimaryButton(
            text = stringResource(R.string.save),
            onClick = { closeBottomSheet(recipe) }
        )
    }
}

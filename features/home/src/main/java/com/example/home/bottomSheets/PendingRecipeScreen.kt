package com.example.home.bottomSheets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.core.data.Recipe
import com.example.ui.components.ScrollingText

@Composable
fun PendingRecipeScreen(
    recipe: Recipe
) {
    Column {
        ScrollingText(
            modifier = Modifier.fillMaxWidth(),
            text = recipe.name,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

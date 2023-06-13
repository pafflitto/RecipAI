package com.example.home.bottomSheets

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.home.HomeViewModel

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun BottomSheetScreen(
    viewModel: HomeViewModel,
    closeBottomSheet: () -> Unit
) {
    AnimatedContent(
        targetState = viewModel.bottomSheetContent
    ) { state ->
        when (state) {
            is BottomSheetContent.RecipeGenerationEntry -> {
                when(state) {
                    is BottomSheetContent.RecipeGenerationEntry.PasteLink -> PasteLinkBottomSheet(
                        dayIndex = state.dayIndex,
                        closeBottomSheet = closeBottomSheet,
                        generateLink = viewModel::generateRecipeFromLink
                    )

                    is BottomSheetContent.RecipeGenerationEntry.Loaded -> {
                        PendingRecipeScreen(recipe = state.recipe)
                    }

                    is BottomSheetContent.None -> { }
                }
            }
            is BottomSheetContent.Instructions -> {
                InstructionsBottomSheet(state = state)
            }
            BottomSheetContent.Error -> {
                Text("error")
            }
            BottomSheetContent.Loading -> {
                Box(Modifier.fillMaxSize()) {
                    CircularProgressIndicator(Modifier.align(Alignment.Center))
                }
            }
            BottomSheetContent.None -> { }
        }
    }
}

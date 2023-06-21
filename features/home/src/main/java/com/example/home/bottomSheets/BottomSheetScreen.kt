package com.example.home.bottomSheets

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
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
        targetState = viewModel.bottomSheetContentState
    ) { state ->
        when (state) {
            is BottomSheetContentState.RecipeGenerationEntry -> {
                when (state) {
                    is BottomSheetContentState.RecipeGenerationEntry.PasteLink -> PasteRecipeBottomSheet(
                        date = state.date,
                        closeBottomSheet = closeBottomSheet,
                        generateLink = viewModel::generateRecipeFromLink
                    )

                    is BottomSheetContentState.RecipeGenerationEntry.Loaded -> {
                        PendingRecipeScreen(
                            recipe = state.recipe,
                            closeBottomSheet = {
                                viewModel.saveRecipe(it, state.date)
                                closeBottomSheet()
                            }
                        )
                    }

                    is BottomSheetContentState.None -> { }
                }
            }
            is BottomSheetContentState.Instructions -> {
                InstructionsBottomSheet(state = state)
            }
            BottomSheetContentState.Error -> {
                Text("error")
            }
            BottomSheetContentState.Loading -> {
                Box(Modifier.fillMaxWidth().fillMaxHeight(0.4f)) {
                    CircularProgressIndicator(Modifier.align(Alignment.Center))
                }
            }
            BottomSheetContentState.None -> { }
        }
    }
}

package com.example.home.bottomSheets

import com.example.core.data.Recipe

sealed class BottomSheetContent {

    object None : BottomSheetContent()

    // Data entry states
    sealed class RecipeGenerationEntry : BottomSheetContent() {
        data class PasteLink(
            val dayIndex: Int
        ) : RecipeGenerationEntry()

        data class Loaded(
            val recipe: Recipe
        ) : RecipeGenerationEntry()
    }

    object Error : BottomSheetContent()

    data class Instructions(
        val instructions: List<String>
    ) : BottomSheetContent()

    object Loading : BottomSheetContent()
}

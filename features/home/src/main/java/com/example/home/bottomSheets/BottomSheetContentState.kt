package com.example.home.bottomSheets

import com.example.core.data.Recipe
import kotlinx.datetime.LocalDate

sealed class BottomSheetContentState {

    object None : BottomSheetContentState()

    // Data entry states
    sealed class RecipeGenerationEntry : BottomSheetContentState() {
        data class PasteLink(
            val date: LocalDate
        ) : RecipeGenerationEntry()

        data class Loaded(
            val date: LocalDate,
            val recipe: Recipe
        ) : RecipeGenerationEntry()
    }

    object Error : BottomSheetContentState()

    data class Instructions(
        val instructions: List<String>
    ) : BottomSheetContentState()

    object Loading : BottomSheetContentState()
}

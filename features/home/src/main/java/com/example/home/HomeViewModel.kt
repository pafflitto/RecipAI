package com.example.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.data.Recipe
import com.example.core.extension.daysInWeek
import com.example.core.repo.AiRepo
import com.example.home.bottomSheets.BottomSheetContentState
import com.example.home.bottomSheets.BottomSheetContentState.Error
import com.example.home.bottomSheets.BottomSheetContentState.Loading
import com.example.home.bottomSheets.BottomSheetContentState.None
import com.example.home.bottomSheets.BottomSheetContentState.RecipeGenerationEntry
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val aiRepo: AiRepo,
    private val clock: Clock
) : ViewModel() {
    var dashboardState by mutableStateOf<DashboardViewState>(DashboardViewState.Loading)
    private var week = clock.now().toLocalDateTime(TimeZone.currentSystemDefault()).date.daysInWeek

    var bottomSheetContentState by mutableStateOf<BottomSheetContentState>(None)

    init {
        loadData()
    }

    private fun loadData() = viewModelScope.launch {
        val today = clock.now().toLocalDateTime(TimeZone.currentSystemDefault()).date

        val recipesForWeek: SnapshotStateList<RecipeForDay> = week.map {
            RecipeForDay(
                recipe = null,
                date = it
            )
        }.toMutableStateList()

        val cuisinesForWeek = recipesForWeek.map {
            it.date to it.recipe?.cuisine
        }.toMutableStateList()

        val todaysIndex = today.dayOfWeek.value % 7
        dashboardState = DashboardViewState.Loaded(
            recipesForWeek = recipesForWeek,
            cuisines = cuisinesForWeek,
            todaysIndex = todaysIndex
        )
    }

    fun toggleIngredientInPantry(toggleParams: UpdateIngredientParams) = viewModelScope.launch {
        val loadedState = dashboardState as DashboardViewState.Loaded
        val recipeForDay = loadedState.recipesForWeek[toggleParams.recipeIndex]
        val ingredients = recipeForDay.recipe?.ingredients?.toMutableList()

        if (ingredients != null) {
            ingredients[toggleParams.ingredientIndex].let {
                it.inPantry.value = !it.inPantry.value
            }
        }
    }

    fun generateRecipeFromLink(url: String, date: LocalDate) = viewModelScope.launch(Dispatchers.IO) {
        bottomSheetContentState = Loading
        aiRepo.requestRecipeFromLink(url)
            .onSuccess {
                bottomSheetContentState = RecipeGenerationEntry.Loaded(
                    recipe = it,
                    date = date
                )
            }
            .onFailure {
                bottomSheetContentState = Error
            }
    }

    fun saveRecipe(recipe: Recipe, date: LocalDate) {
        (dashboardState as DashboardViewState.Loaded).let {
            val dayIndex = date.dayOfWeek.value
            it.recipesForWeek[dayIndex] = RecipeForDay(recipe, it.recipesForWeek[dayIndex].date)
            it.cuisines[dayIndex] = date to recipe.cuisine
        }
    }

    fun setBottomSheetState(state: BottomSheetContentState) {
        bottomSheetContentState = state
    }
}

data class UpdateIngredientParams(
    val recipeIndex: Int,
    val ingredientIndex: Int
)

data class RecipeForDay(
    val recipe: Recipe?,
    val date: LocalDate
)

sealed class DashboardViewState {
    object Loading : DashboardViewState()
    data class Loaded(
        val recipesForWeek: SnapshotStateList<RecipeForDay>,
        val cuisines: SnapshotStateList<Pair<LocalDate, String?>>,
        val todaysIndex: Int
    ) : DashboardViewState()
}

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
import com.example.core.mocks.RecipeMocks
import com.example.core.repo.AiRepo
import com.example.home.bottomSheets.BottomSheetContent
import com.example.home.bottomSheets.BottomSheetContent.*
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

    var bottomSheetContent by mutableStateOf<BottomSheetContent>(None)

    private fun loadData() = viewModelScope.launch {
        val today = clock.now().toLocalDateTime(TimeZone.currentSystemDefault()).date

//        val recipesForWeek: SnapshotStateList<RecipeForDayState> = week.map {
//            RecipeForDayState.Loaded(
//                recipe = null,
//                date = it
//            )
//        }.toMutableStateList()

        val recipesForWeek: SnapshotStateList<RecipeForDay> = week.mapIndexed { index, date ->
            RecipeForDay(
                recipe = RecipeMocks.recipeForWeeks[index],
                date = date
            )
        }.toMutableStateList()

        val cuisinesForWeek = recipesForWeek.map {
            it.date to it.recipe?.cuisine
        }.toMutableStateList()

        val todaysIndex = today.dayOfWeek.value % 7
        dashboardState = DashboardViewState.Loaded(
            recipesForWeek = recipesForWeek,
            cuisines = cuisinesForWeek,
            todaysIndex = todaysIndex,
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

    fun generateRecipeFromLink(url: String, dayIndex: Int) = viewModelScope.launch(Dispatchers.IO) {
        bottomSheetContent = Loading
        aiRepo.requestRecipeFromLink(url)
            .onSuccess {
                bottomSheetContent = RecipeGenerationEntry.Loaded(it)
            }
            .onFailure {
                bottomSheetContent = Error
            }
    }

    fun setBottomSheetState(state: BottomSheetContent) {
        bottomSheetContent = state
    }

    init {
        loadData()
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
        val todaysIndex: Int,
    ) : DashboardViewState()
}

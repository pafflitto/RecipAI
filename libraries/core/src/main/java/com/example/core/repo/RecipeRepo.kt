package com.example.core.repo

import com.example.core.data.Recipe
import com.example.core.data.RecipeForDay
import com.example.core.data.RecipeForDayCombination
import com.example.core.data.RecipeNameForDay
import com.example.core.data.dao.RecipeDao
import com.example.core.extension.daysInWeek
import kotlinx.datetime.LocalDate

interface RecipeRepo {
    suspend fun getRecipesForWeek(date: LocalDate): List<RecipeForDay>
    suspend fun saveRecipeForDay(recipe: Recipe, date: LocalDate)

    suspend fun updateRecipe(recipe: Recipe)
}

class RecipeRepoImpl(
    private val recipeDao: RecipeDao
) : RecipeRepo {
    override suspend fun getRecipesForWeek(date: LocalDate): List<RecipeForDay> =
        date.daysInWeek.map {
            recipeDao.getRecipeForDay(it)?.toRecipeForDay() ?: RecipeForDay(
                date = it,
                recipe = null
            )
        }

    override suspend fun saveRecipeForDay(recipe: Recipe, date: LocalDate) {
        recipeDao.saveRecipe(recipe)
        recipeDao.saveRecipeForDay(
            RecipeNameForDay(
                date,
                recipe.name
            )
        )
    }

    override suspend fun updateRecipe(recipe: Recipe) {
        recipeDao.updateRecipe(recipe)
    }

    private fun RecipeForDayCombination.toRecipeForDay() = RecipeForDay(
        date = recipeNameForDay.date,
        recipe = recipe
    )
}

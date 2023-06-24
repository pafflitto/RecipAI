package com.example.core.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.core.data.Recipe
import com.example.core.data.RecipeForDayCombination
import com.example.core.data.RecipeNameForDay
import kotlinx.datetime.LocalDate

@Dao
abstract class RecipeDao {

    @Transaction
    @Query("SELECT * from recipesForDay WHERE date = :date")
    abstract fun getRecipeForDay(date: LocalDate): RecipeForDayCombination?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun saveRecipe(recipe: Recipe)

    @Insert
    abstract fun saveRecipeForDay(recipeNameForDay: RecipeNameForDay)
}

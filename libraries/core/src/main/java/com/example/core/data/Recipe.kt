package com.example.core.data

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@Serializable
data class RecipeResponse(
    val name: String,
    val cuisine: String,
    val ingredients: List<String>,
    val instructions: List<String>,
    val cookTimeMinutes: Int,
    val prepTimeMinutes: Int,
    val servings: Int
)

fun RecipeResponse.toRecipe() = Recipe(
    name = name,
    cuisine = cuisine,
    ingredients = ingredients.map {
        Ingredient(
            description = it
        )
    },
    instructions = instructions,
    cookTimeMinutes = cookTimeMinutes,
    prepTimeMinutes = prepTimeMinutes,
    servings = servings
)

data class RecipeForDay(
    val date: LocalDate,
    val recipe: Recipe?
)
data class RecipeForDayCombination(
    @Embedded val recipeNameForDay: RecipeNameForDay,
    @Relation(
        entityColumn = "name",
        parentColumn = "recipeName"
    )
    val recipe: Recipe
)

@Entity(tableName = "recipesForDay")
data class RecipeNameForDay(
    @PrimaryKey
    val date: LocalDate,
    val recipeName: String
)

@Entity(tableName = "recipes")
data class Recipe(
    @PrimaryKey
    val name: String,
    val cuisine: String,
    val ingredients: List<Ingredient> = emptyList(),
    val instructions: List<String>,
    val cookTimeMinutes: Int,
    val prepTimeMinutes: Int,
    val servings: Int,
    val isFavorite: MutableState<Boolean> = mutableStateOf(false)
)

data class Ingredient(
    val description: String,
    val inPantry: MutableState<Boolean> = mutableStateOf(false)
)

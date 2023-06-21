package com.example.core.data

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
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

data class Recipe(
    val name: String,
    val cuisine: String,
    val ingredients: List<Ingredient>,
    val instructions: List<String>,
    val cookTimeMinutes: Int,
    val prepTimeMinutes: Int,
    val servings: Int
)

data class Ingredient(
    val description: String,
    val inPantry: MutableState<Boolean> = mutableStateOf(false)
)

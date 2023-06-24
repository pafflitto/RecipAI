package com.example.core.data

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.room.TypeConverter
import kotlinx.datetime.LocalDate

class Converters {

    @TypeConverter
    fun fromEpochDays(value: Int?) = value?.let { LocalDate.fromEpochDays(it) }

    @TypeConverter
    fun localDateToEpochDays(date: LocalDate) = date.toEpochDays()

    @TypeConverter
    fun fromBoolean(value: Boolean?) = value?.let { mutableStateOf(it) }

    @TypeConverter
    fun toBoolean(value: MutableState<Boolean>) = value.value

    @TypeConverter
    fun instructionsToString(value: List<String>) = value.joinToString(separator = ",")

    @TypeConverter
    fun fromStringToInstructions(value: String) = if (value.isEmpty()) {
        emptyList()
    } else {
        value.split(",")
    }

    private val ingredientSeparator = "%&"
    private val ingredientValueSeparator = "$#"

    @TypeConverter
    fun ingredientsToString(value: List<Ingredient>) = value.joinToString(separator = ingredientSeparator) {
        "${it.description}$ingredientValueSeparator${it.inPantry.value}"
    }

    @TypeConverter
    fun stringToIngredients(value: String) = if (value.isEmpty()) {
        emptyList()
    } else {
        value.split(ingredientSeparator).map {
            val values = it.split(ingredientValueSeparator)
            Ingredient(
                description = values[0],
                inPantry = mutableStateOf(values[1].toBoolean())
            )
        }
    }


}

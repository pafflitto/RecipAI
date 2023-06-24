package com.example.core.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.core.data.dao.RecipeDao

@Database(
    entities = [
        RecipeNameForDay::class,
        Recipe::class
    ],
    version = 2
)
@TypeConverters(Converters::class)
internal abstract class RecipAiDb : RoomDatabase() {
    abstract fun recipeDao(): RecipeDao
}
package com.example.core.data

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DataModule {

    @Provides
    @Singleton
    fun provideDb(@ApplicationContext context: Context): RecipAiDb = Room.databaseBuilder(
        context,
        RecipAiDb::class.java,
        "recipai_db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun provideRecipeForDayDao(db: RecipAiDb) = db.recipeDao()
}
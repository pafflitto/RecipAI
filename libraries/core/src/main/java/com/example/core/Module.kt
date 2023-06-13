package com.example.core

import com.example.core.repo.AiRepo
import com.example.core.repo.AiRepoImpl
import com.example.core.service.GenerativeDiscussService
import com.libraries.core.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.datetime.Clock
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {

    @Provides
    @Singleton
    fun provideClock(): Clock = Clock.System

    @Provides
    @Singleton
    fun provideDiscussService(): GenerativeDiscussService = GenerativeDiscussService(
        BuildConfig.PALM_API_KEY
    )

    @Provides
    @Singleton
    fun provideAiRepo(
        discussService: GenerativeDiscussService
    ): AiRepo = AiRepoImpl(
        discussService
    )
}

package com.example.mythirdapplication.di

import android.content.Context
import com.example.mythirdapplication.data.repository.MainRepository
import com.example.mythirdapplication.data.repository.OnBoardingOperationsImpl
import com.example.mythirdapplication.domain.repos.OnBoardingRepos
import com.example.mythirdapplication.domain.use_cases.UseCase
import com.example.mythirdapplication.domain.use_cases.get_onboarding.GetOnBoardingUseCase
import com.example.mythirdapplication.domain.use_cases.set_onboarding.SetOnBoardingUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ReposModule {

    @Provides
    @Singleton
    fun provideOnBoardingOperations(
        @ApplicationContext context: Context
    ): OnBoardingRepos {
        return OnBoardingOperationsImpl(context = context)
    }

    @Provides
    @Singleton
    fun provideUseCases(
        repository: MainRepository
    ): UseCase {
        return UseCase(
            getOnBoardingUseCase = GetOnBoardingUseCase(repository = repository),
            setOnBoardingUseCase = SetOnBoardingUseCase(repository = repository)
        )
    }
}
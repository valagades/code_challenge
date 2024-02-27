package app.code.challenge.kosmosappchallenge.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import app.code.challenge.kosmosappchallenge.domain.repository.ApiRepository
import app.code.challenge.kosmosappchallenge.domain.usecases.GetCharactersByPageUseCase
import app.code.challenge.kosmosappchallenge.domain.usecases.GetCharactersByPageUseCaseImpl

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseProvider {

    @Provides
    @ViewModelScoped
    fun provideGetCharactersByPageUseCase(repository: ApiRepository): GetCharactersByPageUseCase {
        return GetCharactersByPageUseCaseImpl(repository)
    }
}
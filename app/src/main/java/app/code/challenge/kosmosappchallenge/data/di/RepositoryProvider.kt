package app.code.challenge.kosmosappchallenge.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import app.code.challenge.kosmosappchallenge.data.api.ApiService
import app.code.challenge.kosmosappchallenge.domain.repository.ApiRepository
import app.code.challenge.kosmosappchallenge.data.repository.ApiRepositoryImpl
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryProvider {

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideApiRepository(service: ApiService): ApiRepository {
        return ApiRepositoryImpl(service)
    }
}
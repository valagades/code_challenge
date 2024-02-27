package app.code.challenge.kosmosappchallenge.data.repository

import app.code.challenge.kosmosappchallenge.data.api.ApiService
import app.code.challenge.kosmosappchallenge.data.mapper.toModel
import app.code.challenge.kosmosappchallenge.domain.model.CharacterModel
import app.code.challenge.kosmosappchallenge.domain.repository.ApiRepository
import javax.inject.Inject

class ApiRepositoryImpl @Inject constructor(private val service: ApiService) : ApiRepository {

    override suspend fun getCharactersByPage(page: Int): List<CharacterModel> {
        return service.getCharactersByPage(page).body()?.results?.map { it.toModel() } ?: emptyList()
    }
}
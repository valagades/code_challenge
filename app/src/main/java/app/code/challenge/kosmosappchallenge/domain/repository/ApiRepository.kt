package app.code.challenge.kosmosappchallenge.domain.repository

import app.code.challenge.kosmosappchallenge.domain.model.CharacterModel

interface ApiRepository {

    suspend fun getCharactersByPage(page: Int) : List<CharacterModel>
}
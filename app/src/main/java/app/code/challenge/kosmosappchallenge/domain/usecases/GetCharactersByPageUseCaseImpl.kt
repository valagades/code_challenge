package app.code.challenge.kosmosappchallenge.domain.usecases

import app.code.challenge.kosmosappchallenge.domain.mapper.toUI
import app.code.challenge.kosmosappchallenge.domain.repository.ApiRepository
import app.code.challenge.kosmosappchallenge.ui.model.Character
import javax.inject.Inject

class GetCharactersByPageUseCaseImpl @Inject constructor(private val repository: ApiRepository) : GetCharactersByPageUseCase {

    override suspend fun invoke(page: Int): List<Character> {
        return repository.getCharactersByPage(page).map { it.toUI() }
    }
}
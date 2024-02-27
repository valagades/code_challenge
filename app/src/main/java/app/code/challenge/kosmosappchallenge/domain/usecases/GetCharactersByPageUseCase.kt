package app.code.challenge.kosmosappchallenge.domain.usecases

import app.code.challenge.kosmosappchallenge.ui.model.Character

interface GetCharactersByPageUseCase {

    suspend operator fun invoke(page: Int): List<Character>
}
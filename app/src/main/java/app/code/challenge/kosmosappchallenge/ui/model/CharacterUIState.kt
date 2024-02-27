package app.code.challenge.kosmosappchallenge.ui.model

sealed class CharacterUIState {

    object Start : CharacterUIState()
    object Loading : CharacterUIState()
    data class DataLoaded(val characters: List<Character>) : CharacterUIState()
}

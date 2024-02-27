package app.code.challenge.kosmosappchallenge.ui.model

data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val image: String,
    val origin: CharacterOrigin,
    val location: CharacterLocation,
    var showDetails: Boolean
)

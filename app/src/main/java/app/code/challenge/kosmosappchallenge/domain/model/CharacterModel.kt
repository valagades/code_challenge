package app.code.challenge.kosmosappchallenge.domain.model

data class CharacterModel(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val image: String,
    val origin: CharacterOriginModel,
    val location: CharacterLocationModel
)

package app.code.challenge.kosmosappchallenge.data.mapper

import app.code.challenge.kosmosappchallenge.data.model.CharacterResponse
import app.code.challenge.kosmosappchallenge.domain.model.CharacterLocationModel
import app.code.challenge.kosmosappchallenge.domain.model.CharacterModel
import app.code.challenge.kosmosappchallenge.domain.model.CharacterOriginModel

fun CharacterResponse.toModel() = CharacterModel(
    id = this.id,
    name = this.name.orEmpty(),
    status = this.status.orEmpty(),
    species = this.species.orEmpty(),
    type = this.type.orEmpty(),
    gender = this.gender.orEmpty(),
    image = this.image.orEmpty(),
    origin = CharacterOriginModel(this.origin?.name.orEmpty(), this.origin?.url.orEmpty()),
    location = CharacterLocationModel(this.location?.name.orEmpty(), this.location?.url.orEmpty())
)
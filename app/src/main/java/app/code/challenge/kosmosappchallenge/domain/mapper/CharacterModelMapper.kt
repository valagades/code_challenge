package app.code.challenge.kosmosappchallenge.domain.mapper

import app.code.challenge.kosmosappchallenge.domain.model.CharacterModel
import app.code.challenge.kosmosappchallenge.ui.model.Character
import app.code.challenge.kosmosappchallenge.ui.model.CharacterLocation
import app.code.challenge.kosmosappchallenge.ui.model.CharacterOrigin

fun CharacterModel.toUI() = Character(
    id = this.id,
    name = this.name,
    status = this.status,
    species = this.species,
    type = this.type,
    gender = this.gender,
    image = this.image,
    origin = CharacterOrigin(this.origin.name, this.origin.url),
    location = CharacterLocation(this.location.name, this.location.url),
    showDetails = false
)
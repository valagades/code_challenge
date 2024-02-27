package app.code.challenge.kosmosappchallenge.data.model

import com.google.gson.annotations.SerializedName
import app.code.challenge.kosmosappchallenge.utils.GENDER_FIELD
import app.code.challenge.kosmosappchallenge.utils.ID_FIELD
import app.code.challenge.kosmosappchallenge.utils.IMAGE_FIELD
import app.code.challenge.kosmosappchallenge.utils.LOCATION_FIELD
import app.code.challenge.kosmosappchallenge.utils.NAME_FIELD
import app.code.challenge.kosmosappchallenge.utils.ORIGIN_FIELD
import app.code.challenge.kosmosappchallenge.utils.SPECIES_FIELD
import app.code.challenge.kosmosappchallenge.utils.STATUS_FIELD
import app.code.challenge.kosmosappchallenge.utils.TYPE_FIELD

data class CharacterResponse(
    @SerializedName(ID_FIELD) val id: Int,
    @SerializedName(NAME_FIELD) val name: String? = null,
    @SerializedName(STATUS_FIELD) val status: String? = null,
    @SerializedName(SPECIES_FIELD) val species: String? = null,
    @SerializedName(TYPE_FIELD) val type: String? = null,
    @SerializedName(GENDER_FIELD) val gender: String? = null,
    @SerializedName(IMAGE_FIELD) val image: String? = null,
    @SerializedName(ORIGIN_FIELD) val origin: CharacterOriginResponse? = null,
    @SerializedName(LOCATION_FIELD) val location: CharacterLocationResponse? = null
)

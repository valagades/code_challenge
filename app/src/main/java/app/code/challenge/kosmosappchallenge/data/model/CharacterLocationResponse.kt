package app.code.challenge.kosmosappchallenge.data.model

import com.google.gson.annotations.SerializedName
import app.code.challenge.kosmosappchallenge.utils.NAME_FIELD
import app.code.challenge.kosmosappchallenge.utils.URL_FIELD

data class CharacterLocationResponse(
    @SerializedName(NAME_FIELD) val name: String? = null,
    @SerializedName(URL_FIELD) val url: String? = null
)

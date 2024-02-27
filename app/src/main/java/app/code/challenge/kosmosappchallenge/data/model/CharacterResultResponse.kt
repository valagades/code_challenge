package app.code.challenge.kosmosappchallenge.data.model

import com.google.gson.annotations.SerializedName
import app.code.challenge.kosmosappchallenge.utils.RESULTS_FIELD

data class CharacterResultResponse(
    @SerializedName(RESULTS_FIELD) val results: List<CharacterResponse>? = null
)

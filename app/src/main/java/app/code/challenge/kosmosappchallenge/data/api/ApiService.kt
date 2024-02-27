package app.code.challenge.kosmosappchallenge.data.api

import app.code.challenge.kosmosappchallenge.data.model.CharacterResultResponse
import app.code.challenge.kosmosappchallenge.utils.GET_CHARACTERS
import app.code.challenge.kosmosappchallenge.utils.QUERY_PAGE_PARAM
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(GET_CHARACTERS)
    suspend fun getCharactersByPage(@Query(QUERY_PAGE_PARAM) page: Int): Response<CharacterResultResponse>
}
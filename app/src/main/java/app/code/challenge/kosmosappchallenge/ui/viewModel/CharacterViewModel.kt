package app.code.challenge.kosmosappchallenge.ui.viewModel

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import app.code.challenge.kosmosappchallenge.domain.usecases.GetCharactersByPageUseCase
import app.code.challenge.kosmosappchallenge.ui.model.CharacterUIState
import app.code.challenge.kosmosappchallenge.utils.DEFAULT_PAGE
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val getCharactersByPageUseCase: GetCharactersByPageUseCase
) : ViewModel() {

    private val internalUIState = MutableStateFlow<CharacterUIState>(CharacterUIState.Start)
    val uiState = internalUIState.asStateFlow()

    var listState: LazyListState by mutableStateOf(LazyListState(0, 0))

    fun getCharactersByPage() {
        internalUIState.update { CharacterUIState.Loading }
        viewModelScope.launch(Dispatchers.IO) {
            val data = getCharactersByPageUseCase(DEFAULT_PAGE)
            internalUIState.update {
                CharacterUIState.DataLoaded(data)
            }
        }
    }
}
package app.code.challenge.kosmosappchallenge.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import app.code.challenge.kosmosappchallenge.ui.model.Character
import app.code.challenge.kosmosappchallenge.ui.model.CharacterUIState
import app.code.challenge.kosmosappchallenge.ui.viewModel.CharacterViewModel

@Composable
fun CharacterScreen(characterViewModel: CharacterViewModel) {
    val characterUIState by characterViewModel.uiState.collectAsState(initial = CharacterUIState.Start)
    var showDialog by remember { mutableStateOf(false) }

    when (characterUIState) {
        CharacterUIState.Start -> characterViewModel.getCharactersByPage()
        CharacterUIState.Loading -> showDialog = true
        is CharacterUIState.DataLoaded -> {
            showDialog = false
            (characterUIState as? CharacterUIState.DataLoaded)?.characters?.let {
                CharacterListScreen(it, characterViewModel)
            }
        }
    }

    if (showDialog) {
        ProgressIndicator { showDialog = it }
    }
}

@Composable
private fun CharacterListScreen(characters: List<Character>, characterViewModel: CharacterViewModel) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        val (
            listRef
        ) = createRefs()

        LazyColumn(
            state = characterViewModel.listState,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(8.dp),
            modifier = Modifier.constrainAs(listRef, constrainBlock = {
                bottom.linkTo(parent.bottom)
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                height = Dimension.fillToConstraints
                width = Dimension.fillToConstraints
            }),
            content = {
                items(characters, key = { it.id }) { character ->
                    CharacterScreenItem(character)
                }
            })
    }
}
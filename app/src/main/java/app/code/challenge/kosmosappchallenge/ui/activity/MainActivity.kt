package app.code.challenge.kosmosappchallenge.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import app.code.challenge.kosmosappchallenge.ui.screen.CharacterScreen
import app.code.challenge.kosmosappchallenge.ui.theme.KosmosAppChallengeTheme
import app.code.challenge.kosmosappchallenge.ui.viewModel.CharacterViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val characterViewModel: CharacterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KosmosAppChallengeTheme(darkTheme = false) {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    CharacterScreen(characterViewModel)
                }
            }
        }
    }
}
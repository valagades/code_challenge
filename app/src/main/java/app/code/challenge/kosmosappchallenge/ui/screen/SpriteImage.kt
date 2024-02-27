package app.code.challenge.kosmosappchallenge.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.glide.GlideImage
import app.code.challenge.kosmosappchallenge.R

@Composable
fun SpriteImage(url: String, modifier: Modifier) {
    GlideImage(
        imageModel = { url },
        modifier = modifier,
        loading = {
            Box(modifier = Modifier.fillMaxSize(), content = {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center),
                    color = Color.Blue
                )
            })
        },
        failure = {
            DefaultView(modifier)
        }
    )
}

@Composable
private fun DefaultView(modifier: Modifier) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(64.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        border = BorderStroke(1.dp, Color.Green),
        content = {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                content = {
                    Image(
                        painter = painterResource(id = R.drawable.default_image),
                        contentDescription = "Placeholder",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(CircleShape),
                    )
                }
            )
        }
    )
}

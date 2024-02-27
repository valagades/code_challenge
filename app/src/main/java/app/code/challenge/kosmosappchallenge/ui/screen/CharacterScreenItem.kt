package app.code.challenge.kosmosappchallenge.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import app.code.challenge.kosmosappchallenge.R
import app.code.challenge.kosmosappchallenge.ui.model.Character

@Composable
fun CharacterScreenItem(character: Character) {
    val context = LocalContext.current
    var showDetails by remember { mutableStateOf(character.showDetails) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White),
            content = {
                val (
                    spriteRef,
                    nameRef,
                    btnDetailRef,
                    statusRef,
                    speciesRef,
                    typeRef,
                    genderRef,
                    originRef,
                    locationRef
                ) = createRefs()

                // Image
                SpriteImage(
                    url = character.image,
                    modifier = Modifier
                        .width(64.dp)
                        .height(64.dp)
                        .constrainAs(spriteRef, constrainBlock = {
                            top.linkTo(parent.top, margin = 16.dp)
                            start.linkTo(parent.start, margin = 16.dp)
                        })
                )

                // Name
                Text(
                    text = character.name,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.constrainAs(nameRef, constrainBlock = {
                        top.linkTo(spriteRef.top)
                        bottom.linkTo(spriteRef.bottom)
                        start.linkTo(spriteRef.end, margin = 8.dp)
                        end.linkTo(parent.end, margin = 8.dp)
                        width = Dimension.fillToConstraints
                    })
                )

                // Show Details
                Button(
                    onClick = {
                        character.showDetails = character.showDetails.not()
                        showDetails = character.showDetails
                    },
                    modifier = Modifier.constrainAs(btnDetailRef, constrainBlock = {
                        top.linkTo(spriteRef.bottom, margin = 8.dp)
                        start.linkTo(parent.start, margin = 16.dp)
                        end.linkTo(parent.end, margin = 16.dp)
                        width = Dimension.fillToConstraints
                    }),
                    content = {
                        val textBtn = if (showDetails) context.getString(R.string.hide_details) else context.getString(R.string.show_details)
                        Text(text = textBtn)
                    }
                )

                if (showDetails) {
                    // Status
                    Text(
                        text = character.status,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.constrainAs(statusRef, constrainBlock = {
                            top.linkTo(btnDetailRef.bottom, margin = 4.dp)
                            start.linkTo(parent.start, margin = 8.dp)
                            end.linkTo(parent.end, margin = 8.dp)
                            width = Dimension.fillToConstraints
                        })
                    )

                    // Species
                    Text(
                        text = character.species,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.constrainAs(speciesRef, constrainBlock = {
                            top.linkTo(statusRef.bottom, margin = 4.dp)
                            start.linkTo(parent.start, margin = 8.dp)
                            end.linkTo(parent.end, margin = 8.dp)
                            width = Dimension.fillToConstraints
                        })
                    )

                    // Type
                    Text(
                        text = character.type,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.constrainAs(typeRef, constrainBlock = {
                            top.linkTo(speciesRef.bottom, margin = 4.dp)
                            start.linkTo(parent.start, margin = 8.dp)
                            end.linkTo(parent.end, margin = 8.dp)
                            width = Dimension.fillToConstraints
                        })
                    )

                    // Gender
                    Text(
                        text = character.gender,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.constrainAs(genderRef, constrainBlock = {
                            top.linkTo(typeRef.bottom, margin = 4.dp)
                            start.linkTo(parent.start, margin = 8.dp)
                            end.linkTo(parent.end, margin = 8.dp)
                            width = Dimension.fillToConstraints
                        })
                    )

                    // Origin
                    Text(
                        text = character.origin.name,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.constrainAs(originRef, constrainBlock = {
                            top.linkTo(genderRef.bottom, margin = 4.dp)
                            start.linkTo(parent.start, margin = 8.dp)
                            end.linkTo(parent.end, margin = 8.dp)
                            width = Dimension.fillToConstraints
                        })
                    )

                    // Location
                    Text(
                        text = character.location.name,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.constrainAs(locationRef, constrainBlock = {
                            top.linkTo(originRef.bottom, margin = 4.dp)
                            start.linkTo(parent.start, margin = 8.dp)
                            end.linkTo(parent.end, margin = 8.dp)
                            width = Dimension.fillToConstraints
                        })
                    )
                }
            }
        )
    }
}
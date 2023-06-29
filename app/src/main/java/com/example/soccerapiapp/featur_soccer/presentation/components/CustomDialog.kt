package com.example.soccerapiapp.featur_soccer.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.soccerapiapp.R
import com.example.soccerapiapp.featur_soccer.domain.model.Player


@Composable
fun CustomDialog(onDismiss:() -> Unit, player: Player) {
    Dialog(onDismissRequest = onDismiss, properties = DialogProperties(
        usePlatformDefaultWidth = false
    ) ) {
        Card(shape = RoundedCornerShape(10.dp), modifier = Modifier.padding(10.dp)) {
            Column(Modifier.background(MaterialTheme.colorScheme.surface)) {
                Column(modifier = Modifier.fillMaxWidth().padding(top = 20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(player.player_image)
                            .crossfade(true)
                            .build(),
                        contentDescription = null,
                        modifier = Modifier.size(150.dp),
                    )
                }

                Column(modifier = Modifier.padding(10.dp)) {
                    Text(
                        text = player.player_name,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.labelLarge,
                    )
                    Text(
                        text = player.player_rating,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

                Row(Modifier.fillMaxWidth().padding(top = 10.dp).background(MaterialTheme.colorScheme.surface), horizontalArrangement = Arrangement.SpaceAround) {
                    TextButton(onClick = onDismiss) {
                        Text(
                            text = stringResource(id = R.string.back),
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.Black
                        )
                    }
                }
            }
        }
    }
}




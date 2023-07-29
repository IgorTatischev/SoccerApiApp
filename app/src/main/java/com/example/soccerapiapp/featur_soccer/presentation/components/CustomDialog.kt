package com.example.soccerapiapp.featur_soccer.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
fun CustomDialog(onDismiss: () -> Unit, player: Player) {
    Dialog(
        onDismissRequest = onDismiss, properties = DialogProperties(
            usePlatformDefaultWidth = false
        )
    ) {
        Card(shape = RoundedCornerShape(10.dp), modifier = Modifier.padding(10.dp)) {
            Column(Modifier.background(MaterialTheme.colorScheme.surface)) {

                Column(
                    modifier = Modifier.fillMaxWidth().padding(top = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Row {
                        Text(text = player.playerName)
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(text = player.playerRating, color = Color.Red)
                    }

                    Spacer(Modifier.height(10.dp))

                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(player.playerImage)
                            .crossfade(true)
                            .build(),
                        contentDescription = null,
                        modifier = Modifier
                            .size(150.dp)
                            .clip(CircleShape),
                    )
                }

                Column(modifier = Modifier.padding(start = 30.dp, bottom = 20.dp)) {
                    Text(text = stringResource(R.string.age, player.playerAge))
                    Spacer(Modifier.height(10.dp))
                    Row {
                        Text(text = stringResource(R.string.number, player.playerNumber))
                        Spacer(modifier = Modifier.width(20.dp))
                        Text(text = stringResource(R.string.position, player.playerType))
                    }
                    Spacer(Modifier.height(10.dp))
                    Row {
                        Text(text = stringResource(R.string.goals, player.playerGoals))
                        Spacer(modifier = Modifier.width(20.dp))
                        Text(text = stringResource(R.string.assists, player.playerAssists))
                    }
                    Spacer(Modifier.height(10.dp))
                    Text(text = stringResource(R.string.matches, player.playerMatchPlayed))
                    Spacer(Modifier.height(10.dp))
                    Row {
                        Text(text = stringResource(R.string.red_cards, player.playerRedCards))
                        Spacer(modifier = Modifier.width(20.dp))
                        Text(text = stringResource(R.string.yellow_cards, player.playerYellowCards))
                    }
                }

                Divider(color = MaterialTheme.colorScheme.secondary)

                Row(horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(100.dp, 40.dp)
                        .background(MaterialTheme.colorScheme.surface)
                        .clickable {
                            onDismiss()
                        }
                ) {
                    Text(
                        text = stringResource(id = R.string.back),
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.Black,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
            }
        }
    }
}




package com.example.soccerapiapp.featur_soccer.presentation.screens.description

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.RoundedCornersTransformation
import com.example.soccerapiapp.R
import kotlinx.coroutines.launch

@Composable
fun DescriptionScreen(viewModel: DescriptionViewModel = hiltViewModel()) {

    val state = viewModel.state.value
    val match = viewModel.state.value.match
    Box(modifier = Modifier.fillMaxSize()) {
        if (state.isLoading){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
        if (state.error.isNotBlank()){
            Text(
                text = state.error,
                color = androidx.compose.material.MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        else {
            Column(Modifier.fillMaxSize()) {
                Column(modifier = Modifier.fillMaxWidth().padding(top = 15.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    match?.let {
                        Text(
                            text = it.league_name + " " + it.league_season,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Light,
                        )
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    match?.let {
                        Text(
                            text = it.league_round,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Light
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(match?.league_logo)
                            .crossfade(true)
                            .build(),
                        contentDescription = null,
                        modifier = Modifier.size(150.dp),
                    )
                    Spacer(modifier = Modifier.height(40.dp))
                    match?.let {
                        Text(
                            text = it.event_stadium,
                            style = MaterialTheme.typography.bodyMedium,
                            fontSize = 18.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                    //Home Team
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.width(150.dp).padding(start = 10.dp)) {
                        Text(
                            text = stringResource(id = R.string.home),
                            style = MaterialTheme.typography.bodySmall,
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Light
                        )
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(match?.home_team_logo)
                                .crossfade(true)
                                .transformations(RoundedCornersTransformation(50f))
                                .build(),
                            contentDescription = null,
                            modifier = Modifier.size(100.dp),
                            contentScale = ContentScale.Crop
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        match?.let {
                            Text(
                                text = it.homeTeamName,
                                style = MaterialTheme.typography.bodyMedium,
                                fontSize = 24.sp,
                                textAlign = TextAlign.Center
                            )
                        }
                        Spacer(modifier = Modifier.height(5.dp))
                        match?.let {
                            Text(
                                text = it.home_schema,
                                style = MaterialTheme.typography.bodySmall,
                                fontSize = 16.sp,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                    //Score
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .width(100.dp)
                            .padding(start = 5.dp, end = 5.dp)
                    ) {
                        match?.let {
                            Text(
                                text = it.event_ft_result,
                                style = MaterialTheme.typography.bodyLarge,
                                fontSize = 32.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(top = 50.dp),
                                textAlign = TextAlign.Center
                            )
                        }
                        match?.let {
                            Text(
                                text = it.event_time,
                                style = MaterialTheme.typography.bodyMedium,
                                fontSize = 18.sp,
                                modifier = Modifier.padding(top = 5.dp),
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                    //Away Team
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .width(150.dp)
                            .padding(end = 10.dp)
                    ) {
                        Text(
                            text = stringResource(id = R.string.away),
                            style = MaterialTheme.typography.bodySmall,
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Light
                        )
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(match?.away_team_logo)
                                .crossfade(true)
                                .build(),
                            contentDescription = null,
                            modifier = Modifier.size(100.dp),
                            contentScale = ContentScale.Crop
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        match?.let {
                            Text(
                                text = it.awayTeamName,
                                style = MaterialTheme.typography.bodyMedium,
                                fontSize = 24.sp,
                                textAlign = TextAlign.Center
                            )
                        }
                        Spacer(modifier = Modifier.height(5.dp))
                        match?.let {
                            Text(
                                text = it.away_schema,
                                style = MaterialTheme.typography.bodySmall,
                                fontSize = 16.sp,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
        }
    }
}
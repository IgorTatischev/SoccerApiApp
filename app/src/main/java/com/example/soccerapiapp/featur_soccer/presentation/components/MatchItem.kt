package com.example.soccerapiapp.featur_soccer.presentation.components


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.RoundedCornersTransformation
import com.example.soccerapiapp.R
import com.example.soccerapiapp.featur_soccer.domain.model.Match

@Composable
fun MatchItem(match: Match, modifier: Modifier){
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp), //card is reduced in the list
        elevation = 4.dp
    ) {
        Column(modifier.fillMaxSize()) {
            Text(
                text = match.league_name,
                modifier = Modifier
                    .align(CenterHorizontally)
                    .padding(top = 5.dp, bottom = 15.dp),
                fontSize = 12.sp,
                fontWeight = FontWeight.Light,
                color = Color.Gray
            )
            Row(modifier.fillMaxWidth().padding(bottom = 15.dp), horizontalArrangement = Arrangement.Center) {
                Column(
                    horizontalAlignment = CenterHorizontally,
                    modifier = Modifier.width(100.dp).padding(start = 10.dp)) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(match.home_team_logo)
                            //.error(R.drawable.)
                            .crossfade(true)
                            .transformations(RoundedCornersTransformation(50f))
                            .build(),
                        contentDescription = null,
                        modifier = Modifier.size(64.dp),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = match.homeTeamName,
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = stringResource(id = R.string.home),
                        style = MaterialTheme.typography.bodySmall,
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Light
                    )
                }
                Column(
                    horizontalAlignment = CenterHorizontally,
                    modifier = Modifier
                        .width(100.dp)
                        .padding(start = 10.dp, end = 10.dp)
                ) {
                    Text(
                        text = match.event_ft_result,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 10.dp),
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = match.event_time,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(top = 10.dp),
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = match.event_status,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(top = 10.dp),
                        textAlign = TextAlign.Center
                    )
                }
                Column(
                    horizontalAlignment = CenterHorizontally,
                    modifier = Modifier
                        .width(100.dp)
                        .padding(end = 10.dp)
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(match.away_team_logo)
                            //.error(R.drawable.)
                            .crossfade(true)
                            .build(),
                        contentDescription = null,
                        modifier = Modifier.size(64.dp),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = match.awayTeamName,
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = stringResource(id = R.string.away),
                        style = MaterialTheme.typography.bodySmall,
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Light
                    )
                }
            }
        }
    }
}



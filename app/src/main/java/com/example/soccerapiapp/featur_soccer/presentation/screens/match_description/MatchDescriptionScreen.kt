package com.example.soccerapiapp.featur_soccer.presentation.screens.match_description

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
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
import com.example.soccerapiapp.featur_soccer.presentation.components.CustomDialog
import com.example.soccerapiapp.featur_soccer.presentation.components.GoalItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MatchDescriptionScreen(navController: NavController, viewModel: MatchDescriptionViewModel = hiltViewModel()) {

    val scaffoldState = rememberScaffoldState()
    val state = viewModel.state.value
    val match = viewModel.state.value.match

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            CenterAlignedTopAppBar(
                title = { match?.let {
                    Text(
                        text = it.leagueName + " " + it.leagueSeason,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Light,
                    )
                } },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigateUp()
                    }) {
                        Icon(Icons.Rounded.ArrowBack, "Back")
                    }
                },)
        }
    ){ padding ->
        Box(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.surface).padding(padding)) {
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
                Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {
                    Column(modifier = Modifier.fillMaxWidth().padding(top = 20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                        match?.let {
                            Text(
                                text = it.leagueRound,
                                style = MaterialTheme.typography.titleLarge,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Light
                            )
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(match?.leagueLogo)
                                .crossfade(true)
                                .build(),
                            contentDescription = null,
                            modifier = Modifier.size(150.dp),
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Divider(modifier = Modifier.padding(start = 15.dp,end = 15.dp), thickness = 1.dp)
                        Spacer(modifier = Modifier.height(20.dp))
                        match?.let {
                            Text(
                                text = it.eventStadium,
                                style = MaterialTheme.typography.titleLarge,
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
                                style = MaterialTheme.typography.titleMedium,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Light,
                                textAlign = TextAlign.Center,
                                color = Color.Gray
                            )
                            Spacer(modifier = Modifier.height(5.dp))
                            AsyncImage(
                                model = ImageRequest.Builder(LocalContext.current)
                                    .data(match?.homeTeamLogo)
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
                                    style = MaterialTheme.typography.titleLarge,
                                    fontSize = 24.sp,
                                    textAlign = TextAlign.Center
                                )
                            }
                            Spacer(modifier = Modifier.height(5.dp))
                            match?.let {
                                Text(
                                    text = it.homeSchema,
                                    style = MaterialTheme.typography.titleMedium,
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
                                .padding(start = 5.dp, end = 5.dp,top = 50.dp)
                        ) {
                            match?.let {
                                Text(
                                    text = it.eventFtResult,
                                    style = MaterialTheme.typography.headlineLarge,
                                    fontSize = 32.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center
                                )
                            }
                            Spacer(Modifier.height(5.dp))
                            match?.let {
                                Text(
                                    text = it.eventTime,
                                    style = MaterialTheme.typography.titleLarge,
                                    fontSize = 18.sp,
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
                                style = MaterialTheme.typography.titleMedium,
                                fontSize = 16.sp,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Light,
                                color = Color.Gray
                            )
                            Spacer(modifier = Modifier.height(5.dp))
                            AsyncImage(
                                model = ImageRequest.Builder(LocalContext.current)
                                    .data(match?.awayTeamLogo)
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
                                    style = MaterialTheme.typography.titleLarge,
                                    fontSize = 24.sp,
                                    textAlign = TextAlign.Center
                                )
                            }
                            Spacer(modifier = Modifier.height(5.dp))
                            match?.let {
                                Text(
                                    text = it.awaySchema,
                                    style = MaterialTheme.typography.titleMedium,
                                    fontSize = 16.sp,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Divider(modifier = Modifier.padding(start = 15.dp,end = 15.dp), thickness = 1.dp)
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = stringResource(id = R.string.score),
                        modifier = Modifier.padding(start = 15.dp),
                        style = MaterialTheme.typography.headlineSmall,
                        fontSize = 24.sp,
                    )
                    Column {
                        match?.goalscorers?.forEach{ goal ->

                            val id = if (goal.homeScorerId == "") goal.awayScorerId else goal.homeScorerId
                            val teamId = if (goal.homeScorerId == "") match.awayTeamId else match.homeTeamId

                            GoalItem(goal = goal,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        viewModel.onPurchaseClick(id.toLong(), teamId)
                                    }
                                    .padding(10.dp)
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                        }
                    }
                    if(state.isDialogShown){
                        state.player?.let {
                            CustomDialog(onDismiss = { viewModel.onDismissDialog() }, it)
                        }
                    }
                }
            }
        }
    }
}
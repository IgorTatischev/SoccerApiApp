package com.example.soccerapiapp.featur_soccer.presentation.screens.matches

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.soccerapiapp.R
import com.example.soccerapiapp.featur_soccer.presentation.components.MatchItem
import com.example.soccerapiapp.featur_soccer.presentation.navigation.Screen
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MatchesListScreen(navController: NavController, viewModel: MatchesListViewModel = hiltViewModel()) {

    val scaffoldState = rememberScaffoldState()
    val state = viewModel.state.value
    val isRefreshing by viewModel.isRefreshing.collectAsState()
    val pullRefreshState = rememberPullRefreshState(isRefreshing, { viewModel.loadList() })

    Scaffold(scaffoldState = scaffoldState,
        floatingActionButton = {
            Button(modifier = Modifier
                .size(width = 150.dp, height = 50.dp),
            onClick = {
                navController.navigate(Screen.WebViewScreen.route)
            },
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
        ){
            Text(stringResource(id = R.string.webview), color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
            }
        }
    ) {
        Box(modifier = Modifier.pullRefresh(pullRefreshState)) {
            Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(state.matches) { match ->
                        MatchItem(match = match,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp)
                                .clickable {
                                    navController.navigate(
                                        Screen.DescriptionScreen.route + "?matchId=${match.matchId}")
                                })

                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
            }
            if (state.error.isNotBlank()){
                Text(
                    text = state.error,
                    color = MaterialTheme.colorScheme.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }
            if (state.isLoading){
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
            PullRefreshIndicator(
                refreshing = isRefreshing,
                state = pullRefreshState,
                modifier = Modifier.align(Alignment.TopCenter)
            )
        }
    }
}
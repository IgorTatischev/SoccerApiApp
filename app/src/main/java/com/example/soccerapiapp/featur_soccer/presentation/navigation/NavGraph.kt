package com.example.soccerapiapp.featur_soccer.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.soccerapiapp.featur_soccer.presentation.screens.match_description.MatchDescriptionScreen
import com.example.soccerapiapp.featur_soccer.presentation.screens.matches.MatchesListScreen
import com.example.soccerapiapp.featur_soccer.presentation.screens.webview.WebViewScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MatchesScreen.route){
        composable(route = Screen.MatchesScreen.route) { MatchesListScreen(navController) }
        composable(route = Screen.DescriptionScreen.route + "?matchId={matchId}",
            arguments = listOf(
                navArgument(name = "matchId"){
                    type = NavType.IntType
                    defaultValue = -1 },
            )
        ){
            MatchDescriptionScreen(navController)
        }
        composable(route = Screen.WebViewScreen.route) { WebViewScreen() }
    }
}
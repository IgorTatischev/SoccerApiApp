package com.example.soccerapiapp.featur_soccer.presentation.navigation

sealed class Screen(val route: String) {
    object MatchesScreen: Screen("matches_screen")
    object DescriptionScreen: Screen("description_screen")
    object WebViewScreen: Screen("webview_screen")
}
package com.example.soccerapiapp.featur_soccer.presentation.screens.matches

import com.example.soccerapiapp.featur_soccer.domain.model.Match

data class MatchesListState(
    val isLoading : Boolean = false,
    val matches: List<Match> = emptyList(),
    val error: String = "",
)

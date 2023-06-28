package com.example.soccerapiapp.featur_soccer.presentation.screens.matches

import com.example.soccerapiapp.featur_soccer.domain.model.Match
import com.example.soccerapiapp.featur_soccer.utils.MatchOrder

data class MatchesListState(
    val isLoading : Boolean = false,
    val matches: List<Match> = emptyList(),
    val error: String = "",
    val matchOrder: MatchOrder = MatchOrder.None,
)

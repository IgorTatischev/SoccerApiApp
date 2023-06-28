package com.example.soccerapiapp.featur_soccer.presentation.screens.match_description

import com.example.soccerapiapp.featur_soccer.domain.model.Match

data class MatchDescriptionState(
    val isLoading : Boolean = false,
    val match: Match? = null,
    val error: String = "",
)
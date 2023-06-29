package com.example.soccerapiapp.featur_soccer.presentation.screens.match_description

import com.example.soccerapiapp.featur_soccer.domain.model.Match
import com.example.soccerapiapp.featur_soccer.domain.model.Player

data class MatchDescriptionState(
    val isLoading : Boolean = false,
    val match: Match? = null,
    val error: String = "",
    val isDialogShown : Boolean = false,
    val player: Player? = null
)
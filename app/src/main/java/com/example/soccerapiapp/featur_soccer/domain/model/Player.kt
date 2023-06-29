package com.example.soccerapiapp.featur_soccer.domain.model

import com.google.gson.annotations.SerializedName

data class PlayersList(
    val players: List<Player>,
    val success: Int
)

data class Player(
    @SerializedName("player_key")
    val playerId: Long,
    val player_name: String,
    val player_number: String,
    val player_age: String,
    val player_country: Any,
    val player_type: String,
    val player_goals: String,
    val player_assists: String,
    val player_image: String,
    val player_match_played: String,
    val player_red_cards: String,
    val player_yellow_cards: String,
    val player_rating: String
)
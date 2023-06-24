package com.example.soccerapiapp.featur_soccer.domain.model

data class PlayersList(
    val result: List<Player>,
    val success: Int
)

data class Player(
    val player_key: Long,
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
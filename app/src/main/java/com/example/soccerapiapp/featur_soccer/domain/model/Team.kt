package com.example.soccerapiapp.featur_soccer.domain.model

data class TeamsList(
    val result: List<Team>,
    val success: Int
)

data class Team(
    val team_key: Int,
    val team_logo: String,
    val team_name: String,
    val players: List<Players>
)

data class Players(
    val player_key: Long,
    val player_name: String,
    val player_number: String,
    val player_age: String,
    val player_country: Any,
    val player_type: String,
    val player_goals: String,
    val player_image: String,
    val player_match_played: String,
    val player_red_cards: String,
    val player_yellow_cards: String
)

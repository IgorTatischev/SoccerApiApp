package com.example.soccerapiapp.featur_soccer.domain.model

import com.google.gson.annotations.SerializedName

data class PlayersList(
    val success: Int,
    @SerializedName("result")
    val players: List<Player>
)

data class Player(
    @SerializedName("player_key")
    val playerId: Long,
    @SerializedName("player_name")
    val playerName: String,
    @SerializedName("player_number")
    val playerNumber: String,
    @SerializedName("player_age")
    val playerAge: String,
    @SerializedName("player_type")
    val playerType: String,
    @SerializedName("player_goals")
    val playerGoals: String,
    @SerializedName("player_assists")
    val playerAssists: String,
    @SerializedName("player_image")
    val playerImage: String,
    @SerializedName("player_match_played")
    val playerMatchPlayed: String,
    @SerializedName("player_red_cards")
    val playerRedCards: String,
    @SerializedName("player_yellow_cards")
    val playerYellowCards: String,
    @SerializedName("player_rating")
    val playerRating: String
)
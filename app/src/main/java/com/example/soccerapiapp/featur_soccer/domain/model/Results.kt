package com.example.soccerapiapp.featur_soccer.domain.model

import com.google.gson.annotations.SerializedName

data class Results(
    val success: Int,
    @SerializedName("result")
    val matches: List<Match>
)

data class Match(
    @SerializedName("event_key")
    val matchId: Int,
    @SerializedName("away_team_key")
    val awayTeamId: Int,
    val away_team_logo: String,
    @SerializedName("home_team_key")
    val homeTeamId: Int,
    val home_team_logo: String,
    val goalscorers: List<Goalscorer>,
    val event_away_formation: String, //schema
    @SerializedName("event_away_team")
    val awayTeamName: String,
    val event_date: String,
    val event_final_result: String,
    val event_ft_result: String,
    val event_home_formation: String, //schema
    @SerializedName("event_home_team")
    val homeTeamName: String,
    val event_live: String,
    val event_penalty_result: String,
    val event_stadium: String,
    val event_status: String,
    val event_time: String,
    @SerializedName("league_key")
    val leagueId: Int,
    val league_group: Any,
    val league_logo: String,
    val league_name: String,
    val league_round: String,
    val league_season: String,
)

data class Goalscorer(
    @SerializedName("away_scorer")
    val awayScorerName: String,
    @SerializedName("away_scorer_id")
    val awayScorerId: String,
    @SerializedName("home_scorer")
    val homeScorerName: String,
    @SerializedName("home_scorer_id")
    val homeScorerId: String,
    val info_time: String,
    val score: String,
    val time: String
)
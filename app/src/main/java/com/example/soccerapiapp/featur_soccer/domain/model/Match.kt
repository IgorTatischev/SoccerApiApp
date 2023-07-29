package com.example.soccerapiapp.featur_soccer.domain.model

import com.google.gson.annotations.SerializedName

data class MatchesList(
    val success: Int,
    @SerializedName("result")
    val matches: List<Match>
)

data class Match(
    @SerializedName("event_key")
    val matchId: Int,
    @SerializedName("home_team_key")
    val homeTeamId: Int,
    @SerializedName("away_team_key")
    val awayTeamId: Int,
    @SerializedName("event_home_team")
    val homeTeamName: String,
    @SerializedName("event_away_team")
    val awayTeamName: String,
    @SerializedName("away_team_logo")
    val awayTeamLogo: String,
    @SerializedName("home_team_logo")
    val homeTeamLogo: String,
    @SerializedName("event_home_formation")
    val homeSchema: String,
    @SerializedName("event_away_formation")
    val awaySchema: String,
    @SerializedName("event_date")
    val eventDate: String,
    @SerializedName("event_time")
    val eventTime: String,
    @SerializedName("event_final_result")
    val eventFinalResult: String,
    @SerializedName("event_ft_result")
    val eventFtResult: String,
    @SerializedName("event_penalty_result")
    val eventPenaltyResult: String,
    @SerializedName("event_status")
    val eventStatus: String,
    @SerializedName("event_live")
    val eventLive: String,
    @SerializedName("event_stadium")
    val eventStadium: String,
    @SerializedName("league_key")
    val leagueId: Int,
    @SerializedName("league_logo")
    val leagueLogo: String,
    @SerializedName("league_name")
    val leagueName: String,
    @SerializedName("league_round")
    val leagueRound: String,
    @SerializedName("league_season")
    val leagueSeason: String,
    val goalscorers: List<Goals>
)

data class Goals(
    @SerializedName("away_scorer")
    val awayScorerName: String,
    @SerializedName("away_scorer_id")
    val awayScorerId: String,
    @SerializedName("home_scorer")
    val homeScorerName: String,
    @SerializedName("home_scorer_id")
    val homeScorerId: String,
    @SerializedName("info_time")
    val infoTime: String,
    val score: String,
    val time: String
)
package com.example.soccerapiapp.featur_soccer.data.remote

import com.example.soccerapiapp.featur_soccer.domain.model.MatchesList
import com.example.soccerapiapp.featur_soccer.domain.model.PlayersList
import com.example.soccerapiapp.featur_soccer.domain.model.TeamsList
import com.example.soccerapiapp.featur_soccer.utils.Resource
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface SoccerApiService {

    @GET("?met=Fixtures&timezone=Europe/Moscow")
    suspend fun getListMatches(
        @Query("from") from: String,
        @Query("to") to: String
    ): Response<MatchesList>

    @GET("?met=Fixtures&timezone=Europe/Moscow")
    suspend fun getMatch(
        @Query("matchId") matchId: Int
    ): Response<MatchesList>

    @GET("?met=Teams")
    suspend fun getListTeams(
        @Query("leagueId") leagueId: Int
    ): Response<TeamsList>

    @GET("?met=Teams")
    suspend fun getTeam(
        @Query("teamId") teamId: Int
    ): Response<TeamsList>

    @GET("?met=Players")
    suspend fun getPlayer(
        @Query("playerId") playerId: Int,
        @Query("teamId") teamId: Int
    ): Response<PlayersList>
}
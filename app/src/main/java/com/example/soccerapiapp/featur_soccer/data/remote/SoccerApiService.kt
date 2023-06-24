package com.example.soccerapiapp.featur_soccer.data.remote

import com.example.soccerapiapp.featur_soccer.domain.model.MatchesList
import com.example.soccerapiapp.featur_soccer.domain.model.PlayersList
import com.example.soccerapiapp.featur_soccer.domain.model.TeamsList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SoccerApiService {

    @GET("?met=Fixtures&timezone=Europe/Moscow&APIkey=e45b2a8c9c8527b8de7d5d7ed5961f5086f80d8d32867b63b84deddf61cb9a47")
    suspend fun getListMatches(
        @Query("from") from: String,
        @Query("to") to: String
    ): Response<MatchesList>

    @GET("?met=Fixtures&timezone=Europe/Moscow&APIkey=e45b2a8c9c8527b8de7d5d7ed5961f5086f80d8d32867b63b84deddf61cb9a47")
    suspend fun getMatch(
        @Query("matchId") matchId: Int
    ): Response<MatchesList>

    @GET("?met=Teams&APIkey=e45b2a8c9c8527b8de7d5d7ed5961f5086f80d8d32867b63b84deddf61cb9a47")
    suspend fun getListTeams(
        @Query("leagueId") leagueId: Int
    ): Response<TeamsList>

    @GET("?met=Teams&APIkey=e45b2a8c9c8527b8de7d5d7ed5961f5086f80d8d32867b63b84deddf61cb9a47")
    suspend fun getTeam(
        @Query("teamId") teamId: Int
    ): Response<TeamsList>

    @GET("?met=Players&APIkey=e45b2a8c9c8527b8de7d5d7ed5961f5086f80d8d32867b63b84deddf61cb9a47")
    suspend fun getPlayer(
        @Query("playerId") playerId: Int,
        @Query("teamId") teamId: Int
    ): Response<PlayersList>
}
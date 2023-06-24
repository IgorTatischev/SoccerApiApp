package com.example.soccerapiapp.featur_soccer.data.repository

import com.example.soccerapiapp.featur_soccer.data.remote.SoccerApiService
import com.example.soccerapiapp.featur_soccer.domain.model.PlayersList
import com.example.soccerapiapp.featur_soccer.domain.model.TeamsList
import com.example.soccerapiapp.featur_soccer.domain.repository.SoccerRepository
import com.example.soccerapiapp.featur_soccer.utils.BaseDataSource
import com.example.soccerapiapp.featur_soccer.utils.Resource
import javax.inject.Inject

class SoccerRepositoryImpl @Inject constructor(private val soccerApiService: SoccerApiService): SoccerRepository, BaseDataSource() {

    override suspend fun getMatches(from: String, to: String) = safeApiCall { soccerApiService.getListMatches(from, to) }

    override suspend fun getMatchById(id: Int) = safeApiCall { soccerApiService.getMatch(id) }
    override suspend fun getTeamById(id: Int) = safeApiCall { soccerApiService.getTeam(id) }

    override suspend fun getTeamsInLeague(id: Int) = safeApiCall { soccerApiService.getListTeams(id) }

    override suspend fun getPlayerById(playerId: Int, teamId: Int) = safeApiCall { soccerApiService.getPlayer(playerId, teamId) }
}
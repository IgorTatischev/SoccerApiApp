package com.example.soccerapiapp.featur_soccer.data.repository

import com.example.soccerapiapp.featur_soccer.data.remote.SoccerApiService
import com.example.soccerapiapp.featur_soccer.domain.repository.SoccerRepository
import com.example.soccerapiapp.featur_soccer.utils.BaseDataSource
import javax.inject.Inject

class SoccerRepositoryImpl @Inject constructor(private val soccerApiService: SoccerApiService): SoccerRepository, BaseDataSource() {
    override suspend fun getMatches(from: String, to: String) = safeApiCall { soccerApiService.getListMatches(from, to) }
    override suspend fun getMatchById(id: Int) = safeApiCall { soccerApiService.getMatch(id) }
    override suspend fun getPlayerById(playerId: Long, teamId: Int) = safeApiCall { soccerApiService.getPlayer(playerId, teamId) }
}
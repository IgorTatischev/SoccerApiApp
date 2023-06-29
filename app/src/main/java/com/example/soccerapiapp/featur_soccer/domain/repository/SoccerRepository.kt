package com.example.soccerapiapp.featur_soccer.domain.repository

import com.example.soccerapiapp.featur_soccer.domain.model.MatchesList
import com.example.soccerapiapp.featur_soccer.domain.model.PlayersList
import com.example.soccerapiapp.featur_soccer.utils.Resource

interface SoccerRepository {
    suspend fun getMatches(from: String,to: String) : Resource<MatchesList>
    suspend fun getMatchById(id: Int): Resource<MatchesList>
    suspend fun getPlayerById(playerId: Long,teamId: Int): Resource<PlayersList>
}
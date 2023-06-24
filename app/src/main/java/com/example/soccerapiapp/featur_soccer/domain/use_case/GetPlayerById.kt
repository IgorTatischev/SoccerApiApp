package com.example.soccerapiapp.featur_soccer.domain.use_case

import com.example.soccerapiapp.featur_soccer.domain.model.MatchesList
import com.example.soccerapiapp.featur_soccer.domain.model.PlayersList
import com.example.soccerapiapp.featur_soccer.domain.repository.SoccerRepository
import com.example.soccerapiapp.featur_soccer.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetPlayerById @Inject constructor(private val repository: SoccerRepository) {
    operator fun invoke(playerId: Int,teamId: Int): Flow<Resource<PlayersList>> = flow {
        emit(repository.getPlayerById(playerId, teamId))
    }.flowOn(Dispatchers.IO)
}
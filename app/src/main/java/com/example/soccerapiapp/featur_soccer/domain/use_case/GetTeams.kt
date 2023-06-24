package com.example.soccerapiapp.featur_soccer.domain.use_case

import com.example.soccerapiapp.featur_soccer.domain.model.TeamsList
import com.example.soccerapiapp.featur_soccer.domain.repository.SoccerRepository
import com.example.soccerapiapp.featur_soccer.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetTeams @Inject constructor(private val repository: SoccerRepository) {
    operator fun invoke(leagueId: Int): Flow<Resource<TeamsList>> = flow {
        emit(repository.getTeamsInLeague(leagueId))
    }.flowOn(Dispatchers.IO)
}
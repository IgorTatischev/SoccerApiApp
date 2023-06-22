package com.example.soccerapiapp.featur_soccer.domain.use_case

import com.example.soccerapiapp.featur_soccer.domain.model.Results
import com.example.soccerapiapp.featur_soccer.domain.repository.SoccerRepository
import com.example.soccerapiapp.featur_soccer.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetMatches @Inject constructor(private val repository: SoccerRepository) {
    operator fun invoke(from: String, to: String): Flow<Resource<Results>> = flow {
        emit(repository.getMatches(from, to))
    }.flowOn(Dispatchers.IO)
}
package com.example.soccerapiapp.featur_soccer.domain.repository

import com.example.soccerapiapp.featur_soccer.domain.model.Results
import com.example.soccerapiapp.featur_soccer.utils.Resource

interface SoccerRepository {
    suspend fun getMatches(from: String,to: String) : Resource<Results>
    suspend fun getMatchById(id: Int): Resource<Results>
}
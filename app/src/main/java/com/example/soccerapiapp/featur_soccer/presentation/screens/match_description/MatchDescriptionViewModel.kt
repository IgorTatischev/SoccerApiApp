package com.example.soccerapiapp.featur_soccer.presentation.screens.match_description

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.soccerapiapp.featur_soccer.domain.use_case.GetMatchesById
import com.example.soccerapiapp.featur_soccer.domain.use_case.GetPlayerById
import com.example.soccerapiapp.featur_soccer.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MatchDescriptionViewModel @Inject constructor(
    private val getMatchUseCase: GetMatchesById,
    private val getPlayerUseCase: GetPlayerById,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(MatchDescriptionState())
    val state: State<MatchDescriptionState> = _state

    fun onPurchaseClick(id: Long, teamId: Int){
        getGoalScorerPlayer(id, teamId)
    }
    fun onDismissDialog(){
        _state.value = state.value.copy(isDialogShown = false)
    }

    init {
        savedStateHandle.get<Int>("matchId")?.let { id ->
            getDescriptionMatch(id)
        }
    }

    private fun getDescriptionMatch(id: Int) {
        getMatchUseCase(id).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = MatchDescriptionState(match = result.data?.matches?.get(0))
                }
                is Resource.Error -> {
                    _state.value = MatchDescriptionState(error = result.message ?: "unexpected error")
                }
                is Resource.Loading -> {
                    _state.value = MatchDescriptionState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getGoalScorerPlayer(id: Long, teamId: Int) {
        getPlayerUseCase(id, teamId).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = state.value.copy(player = result.data?.players?.get(0), isDialogShown = true)
                }
                else -> {
                    _state.value = state.value.copy(isDialogShown = false)
                }
            }
        }.launchIn(viewModelScope)
    }
}
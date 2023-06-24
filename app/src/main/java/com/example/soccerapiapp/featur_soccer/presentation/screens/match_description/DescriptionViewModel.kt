package com.example.soccerapiapp.featur_soccer.presentation.screens.match_description

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.soccerapiapp.featur_soccer.domain.use_case.GetMatchesById
import com.example.soccerapiapp.featur_soccer.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DescriptionViewModel @Inject constructor(
    private val getMatchUseCase: GetMatchesById,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(DescriptionState())
    val state: State<DescriptionState> = _state

    init {
        savedStateHandle.get<Int>("matchId")?.let { id ->
            getDescriptionMatch(id)
        }
    }

    private fun getDescriptionMatch(id: Int) {
        getMatchUseCase(id).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = DescriptionState(match = result.data?.matches?.get(0))
                }
                is Resource.Error -> {
                    _state.value = DescriptionState(error = result.message ?: "unexpected error")
                }
                is Resource.Loading -> {
                    _state.value = DescriptionState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
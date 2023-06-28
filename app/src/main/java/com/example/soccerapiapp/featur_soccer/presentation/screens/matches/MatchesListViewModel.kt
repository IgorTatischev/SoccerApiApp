package com.example.soccerapiapp.featur_soccer.presentation.screens.matches

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.soccerapiapp.featur_soccer.domain.model.Match
import com.example.soccerapiapp.featur_soccer.domain.use_case.GetMatches
import com.example.soccerapiapp.featur_soccer.utils.MatchOrder
import com.example.soccerapiapp.featur_soccer.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class MatchesListViewModel @Inject constructor(private val getMatchesUseCase: GetMatches) : ViewModel(){

    private val _state = mutableStateOf(MatchesListState())
    val state: State<MatchesListState> = _state

    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing = _isRefreshing.asStateFlow()

    private val today: String = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        .format(Date())
    private val yesterday: String = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        .format(Date(System.currentTimeMillis() - 1000 * 60 * 60 * 24))
    private val tomorrow: String = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        .format(Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))

    init {
        loadList(today)
    }
    private var defaultList: List<Match> = emptyList()

    private fun loadList(currentDate: String) {
        getMatchesUseCase(currentDate, currentDate).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    defaultList = result.data?.matches ?: emptyList()
                    _state.value = MatchesListState(matches = defaultList)
                    _isRefreshing.value = false
                }
                is Resource.Error -> {
                    _state.value = MatchesListState(error = result.message ?: "unexpected error")
                }
                is Resource.Loading -> {
                    _state.value = MatchesListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun getListMatches(matchOrder: MatchOrder){
        when (matchOrder) {
            is MatchOrder.Yesterday -> loadList(yesterday)
            is MatchOrder.Tomorrow -> loadList(tomorrow)
            is MatchOrder.None -> loadList(today)
        }
    }
}
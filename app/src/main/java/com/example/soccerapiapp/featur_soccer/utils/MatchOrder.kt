package com.example.soccerapiapp.featur_soccer.utils

sealed class MatchOrder{
    object Yesterday : MatchOrder()
    object Tomorrow : MatchOrder()
    object None : MatchOrder()
}

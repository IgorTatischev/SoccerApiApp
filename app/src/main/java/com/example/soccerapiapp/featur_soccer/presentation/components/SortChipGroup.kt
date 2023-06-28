package com.example.soccerapiapp.featur_soccer.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.soccerapiapp.featur_soccer.utils.MatchOrder

@Composable
fun SortChipGroup(
    hotelOrder: MatchOrder = MatchOrder.None,
    onOrderChange: (MatchOrder) -> Unit) {

    val selected = remember { mutableStateOf(hotelOrder) }
    val chipList: List<MatchOrder> = listOf(MatchOrder.Yesterday, MatchOrder.Tomorrow)

    Row(modifier = Modifier.fillMaxWidth()) {
        chipList.forEach {
            SortChip(
                title = if (it is MatchOrder.Yesterday) "Yesterday" else "Tomorrow",
                selected = selected.value == it && selected.value != MatchOrder.None,
                onSelected = {
                    if (selected.value == it && selected.value != MatchOrder.None)
                        selected.value = MatchOrder.None
                    else {
                        selected.value = it
                    }
                    onOrderChange(selected.value)
                }
            )
        }
    }
}
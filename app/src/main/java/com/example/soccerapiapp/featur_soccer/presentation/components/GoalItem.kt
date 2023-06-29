package com.example.soccerapiapp.featur_soccer.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.soccerapiapp.featur_soccer.domain.model.Goals

@Composable
fun GoalItem(goal: Goals, modifier: Modifier){
    Card(
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        elevation = 4.dp
    ) {
        Row(modifier.fillMaxSize().padding(start = 10.dp)) {
            Text(
                text = goal.info_time,
                style = MaterialTheme.typography.titleMedium,
                fontSize = 16.sp
            )
            Spacer(Modifier.width(10.dp))
            Text(
                text = goal.time + " '",
                style = MaterialTheme.typography.titleMedium,
                fontSize = 16.sp,
                color = Color.Red
            )
            Spacer(Modifier.width(10.dp))
            Text(
                text = goal.score,
                style = MaterialTheme.typography.titleMedium,
                fontSize = 16.sp
            )
            Spacer(Modifier.width(20.dp))
            Text(
                text = if (goal.homeScorerName == "") goal.awayScorerName else goal.homeScorerName,
                style = MaterialTheme.typography.titleMedium,
                fontSize = 16.sp
            )
        }
    }
}

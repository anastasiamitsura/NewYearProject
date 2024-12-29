package com.example.newyearproject.presentation.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newyearproject.data.models.SearchModel
import com.example.newyearproject.data.models.UserModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.spec.Direction

@Destination
@Composable
fun DetailsScreenSearchContent(
    search: SearchModel,
): Direction {
    Column {
        Text("Имя запроса: ${search.name}", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(10.dp))
        Text("Дата запроса: ${search.date}", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(10.dp))
        Text("Описание запроса: ${search.description}", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(10.dp))
    }
}
package com.example.newyearproject.presentation.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newyearproject.data.models.UserModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.spec.Direction

@Destination
@Composable
fun DetailsScreenUserContent(
    user: UserModel,
): Direction {
    Column {
        Text("Hello ${user.login}!", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(10.dp))
        Text("ID: ${user.id}", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(10.dp))
    }
}
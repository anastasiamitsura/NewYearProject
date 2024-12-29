package com.example.newyearproject.presentation.components.user

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.newyearproject.data.models.UserModel
import com.example.newyearproject.presentation.contract.AllEvent
import com.example.newyearproject.presentation.contract.AllState

@Composable
fun UsersScreenContent(
    uiState: AllState,
    onEvent: (AllEvent) -> Unit,
) {
    Column (modifier = Modifier){
        Column(
            modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
        ) {

            LazyColumn {
                uiState.users.forEach { item ->
                    item {
                        UserCard(item, onEvent)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun UsersScreenContentPreview() {
    UsersScreenContent(
        uiState = AllState(
            usersName = "test",
            users = listOf(
                UserModel(
                    id = "Name",
                    login= "",
                    imageUrl = "",
                )
            )
        ), { _ -> }
    )
}

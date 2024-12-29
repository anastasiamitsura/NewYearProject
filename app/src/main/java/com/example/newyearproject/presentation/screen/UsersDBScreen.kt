package com.example.newyearproject.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newyearproject.data.models.UserModel
import com.example.newyearproject.presentation.components.user.UserCard
import com.example.newyearproject.presentation.contract.AllEvent
import com.example.newyearproject.presentation.contract.AllState

@Composable
fun UsersDBScreen(
    uiState: AllState,
    onEvent: (AllEvent) -> Unit,
) {
    Column {
        Column(
            modifier = Modifier.fillMaxWidth(),
        ) {
            TextField(value = uiState.usersName,
                onValueChange = { changedValue -> onEvent(AllEvent.UpdateUsersTextField(changedValue)) },
                label = { Text("Enter item name") })
            TextField(value = uiState.usersUrl,
                onValueChange = { changedValue -> onEvent(AllEvent.UpdateUsersUrlField(changedValue)) },
                label = { Text("Enter url") })
            Button(
                modifier = Modifier.padding(start = 14.dp),
                onClick = {
                    onEvent(AllEvent.AddUserButtonClicked)
                }) {
                Text(text = "Add")
            }
        }

        LazyColumn {
            uiState.users.forEach { item ->
                item {
                    UserCard(item, onEvent)
                }
            }
        }
    }
}

@Preview
@Composable
private fun UsersDBScreenPreview() {
    UsersDBScreen(
        uiState = AllState(
            usersName = "test",
            users = listOf(
                UserModel(
                    login = "Name",
                    id = "",
                    imageUrl = ""
                )
            )
        )
    ) { _ -> }
}
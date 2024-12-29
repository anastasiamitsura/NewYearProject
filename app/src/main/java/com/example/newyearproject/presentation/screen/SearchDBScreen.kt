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
import com.example.newyearproject.data.models.SearchModel
import com.example.newyearproject.data.models.UserModel
import com.example.newyearproject.presentation.components.user.SearchCard
import com.example.newyearproject.presentation.components.user.UserCard
import com.example.newyearproject.presentation.contract.AllEvent
import com.example.newyearproject.presentation.contract.AllState

@Composable
fun SearchDBScreen(
    uiState: AllState,
    onEvent: (AllEvent) -> Unit,
) {
    Column {
        Column(
            modifier = Modifier.fillMaxWidth(),
        ) {
            TextField(value = uiState.searchName,
                onValueChange = { changedValue -> onEvent(AllEvent.UpdateSearchTextField(changedValue)) },
                label = { Text("Enter item name") })
            TextField(value = uiState.searchDes,
                onValueChange = { changedValue -> onEvent(AllEvent.UpdateSearchDesField(changedValue)) },
                label = { Text("Enter description") })
            Button(
                modifier = Modifier.padding(start = 14.dp),
                onClick = {
                    onEvent(AllEvent.AddSearchButtonClicked)
                }) {
                Text(text = "Add")
            }
        }

        LazyColumn {
            uiState.search.forEach { item ->
                item {
                    SearchCard(item, onEvent)
                }
            }
        }
    }
}

@Preview
@Composable
private fun SearchDBScreenPreview() {
    SearchDBScreen(
        uiState = AllState(
            searchName = "test",
            search = listOf(
                SearchModel(
                    name = "Name",
                    description = "",
                    date = ""
                )
            )
        )
    ) { _ -> }
}
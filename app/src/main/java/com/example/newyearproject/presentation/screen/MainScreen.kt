package com.example.newyearproject.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.newyearproject.data.models.UserModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination(start = true)
@Composable
fun MainScreen(
    navigator: DestinationsNavigator
) {
    Column (modifier = Modifier.fillMaxHeight()){
        Column(
            modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                modifier = Modifier.width(200.dp).padding(10.dp).height(60.dp),
                onClick = {
                    navigator.navigate(UsersScreen())
                }) {
                Text(text = "Show Users")
            }
            Button(
                modifier = Modifier.width(200.dp).padding(10.dp).height(60.dp),
                onClick = {
                    navigator.navigate(SearchScreen())
                }) {
                Text(text = "Show Objects")
            }
            Button(
                modifier = Modifier.width(200.dp).padding(10.dp).height(60.dp),
                onClick = {
                    navigator.navigate(UsersDBScreen())
                }) {
                Text(text = "Add User")
            }
            Button(
                modifier = Modifier.width(200.dp).padding(10.dp).height(60.dp),
                onClick = {
                    navigator.navigate(SearchDBScreen())
                }) {
                Text(text = "Add Object")
            }
        }

    }
}

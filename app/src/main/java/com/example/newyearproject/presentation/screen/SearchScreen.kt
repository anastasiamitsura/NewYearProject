package com.example.newyearproject.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.newyearproject.presentation.components.user.UsersScreenContent
import com.example.newyearproject.presentation.contract.AllEffect
import com.example.newyearproject.presentation.contract.AllEvent
import com.example.newyearproject.presentation.contract.AllState
import com.example.newyearproject.presentation.details.DetailsScreenSearchContent
import com.example.newyearproject.presentation.viewModels.ViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.flow.collectLatest

@Destination
@Composable
fun SearchScreen(
    //uiState: AllState,
    //onEvent: (AllEvent) -> Unit,
    navigator: DestinationsNavigator,
) {

    val viewModel = viewModel<ViewModel>()

    val state by viewModel.state.collectAsState()

    UsersScreenContent(
        uiState = state,
        onEvent = viewModel::handleEvent
    )

    LaunchedEffect(viewModel.effect) {
        viewModel.effect.collectLatest { effect ->
            when (effect) {
                is AllEffect.OpenDetails_Search -> {
                    navigator.navigate(DetailsScreenSearchContent(search = effect.item))
                }
            }
        }
    }
}
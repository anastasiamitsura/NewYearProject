package com.example.newyearproject.presentation.contract

import com.example.newyearproject.data.models.SearchModel
import com.example.newyearproject.data.models.UserModel

sealed class AllEvent {

    data class UpdateUsersTextField(val text: String): AllEvent()
    data class UpdateUsersUrlField(val url: String): AllEvent()
    data class OnUserItemClick(val user: UserModel): AllEvent()
    data object AddUserButtonClicked: AllEvent()

    data class UpdateSearchTextField(val name: String): AllEvent()
    data class UpdateSearchDesField(val description: String): AllEvent()
    data class OnSearchItemClick(val query: SearchModel): AllEvent()
    data object AddSearchButtonClicked: AllEvent()
}

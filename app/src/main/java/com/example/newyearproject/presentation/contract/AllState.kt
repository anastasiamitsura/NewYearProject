package com.example.newyearproject.presentation.contract

import com.example.newyearproject.data.models.SearchModel
import com.example.newyearproject.data.models.UserModel

data class AllState(
    val usersName: String = "",
    val usersUrl: String = "",
    val users: List<UserModel> = emptyList(),

    val searchName: String = "",
    val searchDes: String = "",
    val search: List<SearchModel> = emptyList()
)
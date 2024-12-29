package com.example.newyearproject.presentation.contract

import com.example.newyearproject.data.models.SearchModel
import com.example.newyearproject.data.models.UserModel

sealed interface AllEffect {

    data class OpenDetails_Users(val item: UserModel): AllEffect

    data class OpenDetails_Search(val item: SearchModel): AllEffect
}
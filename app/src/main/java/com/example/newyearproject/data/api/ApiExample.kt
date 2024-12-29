package com.example.newyearproject.data.api

import com.example.newyearproject.data.models.SearchModel
import com.example.newyearproject.data.models.UserModel
import retrofit2.http.GET

interface ApiExample {

    @GET("/users?since=<string>&per_page=30") // Текст запроса
    suspend fun getUsers(): List<UserModel>

    @GET("/search/topics?q=%3Cstring%3E&per_page=30")
    suspend fun getSearch(): List<SearchModel>
}
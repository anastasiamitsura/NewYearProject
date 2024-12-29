package com.example.newyearproject.data.models

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class SearchModel(

    @SerializedName("name")
    val name: String,

    @SerializedName("created_at")
    val date: String,

    @SerializedName("description")
    val description: String,
)
package com.example.newyearproject.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newyearproject.data.api.ApiExample
import com.example.newyearproject.data.api.App
import com.example.newyearproject.data.models.SearchModel
import com.example.newyearproject.data.models.UserModel
import com.example.newyearproject.presentation.contract.AllEffect
import com.example.newyearproject.presentation.contract.AllEvent
import com.example.newyearproject.presentation.contract.AllState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient.Builder
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ViewModel : ViewModel() {

    val state = MutableStateFlow(AllState())

    private val _effect = Channel<AllEffect>()
    val effect = _effect.receiveAsFlow()

    private fun getClient(): ApiExample {
        val httpClient = Builder()
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        httpClient.addInterceptor(logging)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()

        return retrofit.create(ApiExample::class.java)
    }

    fun handleEvent(event: AllEvent) {
        when (event) {
            is AllEvent.UpdateUsersTextField -> {
                state.value = state.value.copy(usersName = event.text)
            }

            is AllEvent.OnUserItemClick -> {
                viewModelScope.launch {
                    _effect.send(AllEffect.OpenDetails_Users(event.user))
                }
            }

            AllEvent.AddUserButtonClicked -> {
                App.getDatabase_Users()?.clearAllTables()
                val client = getClient()

                viewModelScope.launch {
                    try {
                        App.getDatabase_Users()?.userDao()?.let { dao ->
                            val users = client.getUsers()
                            state.value = state.value.copy(
                                users = users.map {
                                    UserModel(
                                        id = it.id,
                                        login = it.login,
                                        imageUrl = it.imageUrl
                                    )
                                },
                                usersName = ""
                            )
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }

            is AllEvent.UpdateUsersUrlField -> {
                state.value = state.value.copy(usersUrl = event.url)
            }

            is AllEvent.UpdateSearchTextField -> {
                state.value = state.value.copy(searchName = event.name)
            }

            is AllEvent.OnSearchItemClick -> {
                viewModelScope.launch {
                    _effect.send(AllEffect.OpenDetails_Search(event.query))
                }
            }

            AllEvent.AddSearchButtonClicked -> {
                App.getDatabase_Search()?.clearAllTables()
                val client = getClient()

                viewModelScope.launch {
                    try {
                        App.getDatabase_Search()?.searchDao()?.let { dao ->
                            val search = client.getSearch()
                            state.value = state.value.copy(
                                search = search.map {
                                    SearchModel(
                                        name = it.name,
                                        description = it.description,
                                        date = it.date
                                    )
                                },
                                usersName = ""
                            )
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }

            is AllEvent.UpdateSearchDesField -> {
                state.value = state.value.copy(searchDes = event.description)
            }
        }
    }

    fun isNumeric(toCheck: String): Boolean {
        return toCheck.all { char -> char.isDigit() }
    }
}
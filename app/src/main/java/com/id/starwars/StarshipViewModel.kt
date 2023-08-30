package com.id.starwars

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.id.starwars.models.Starship
import com.id.starwars.services.RetrofitClient
import com.id.starwars.services.StarWarsApiService
import kotlinx.coroutines.launch

class StarshipViewModel : ViewModel() {

    private val starshipApiService = RetrofitClient.createService(StarWarsApiService::class.java)
    private val starships = mutableListOf<Starship>()
    private var currentPage = 1

    private val _starshipList = MutableLiveData<List<Starship>>()
    val starshipList: LiveData<List<Starship>> = _starshipList

    init {
        loadMoreStarships()
    }

    fun loadMoreStarships() {
        viewModelScope.launch {
            try {
                val response = starshipApiService.getStarships(currentPage)
                if (response.isSuccessful) {
                    val newStarships = response.body()?.results ?: emptyList()
                    starships.addAll(newStarships)
                    _starshipList.value = starships
                    currentPage++
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}

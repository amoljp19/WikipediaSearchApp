package com.softaai.wikipedia_search_app.wikipediasearch.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.softaai.wikipedia_search_app.model.Page
import com.softaai.wikipedia_search_app.repository.WikiSearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WikiSearchViewModel @Inject constructor(private val wikiSearchRepository: WikiSearchRepository) : ViewModel() {

    val allPages: LiveData<List<Page>> = wikiSearchRepository.allUsers.asLiveData()


    fun insert(page: Page) = viewModelScope.launch {
        wikiSearchRepository.insert(page)
    }
}
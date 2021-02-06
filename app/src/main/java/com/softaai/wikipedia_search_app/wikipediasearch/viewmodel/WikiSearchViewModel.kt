package com.softaai.wikipedia_search_app.wikipediasearch.viewmodel

import androidx.lifecycle.*
import com.softaai.wikipedia_search_app.model.Page
import com.softaai.wikipedia_search_app.repository.WikiSearchRepository
import com.softaai.wikipedia_search_app.wikipediasearch.viewmodel.base.LiveCoroutinesViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WikiSearchViewModel @Inject constructor(private val wikiSearchRepository: WikiSearchRepository) : LiveCoroutinesViewModel() {

//    val allPages: LiveData<List<Page>> = wikiSearchRepository.allUsers.asLiveData()
//
//
//    fun insert(page: Page) = viewModelScope.launch {
//        wikiSearchRepository.insert(page)
//    }

    private var wikiPageFetchingLiveData: MutableLiveData<Boolean> = MutableLiveData()
    val wikiSearchPageListLiveData: LiveData<List<Page>>

    val toastLiveData: MutableLiveData<String> = MutableLiveData()

    init {

        this.wikiSearchPageListLiveData = this.wikiPageFetchingLiveData.switchMap {
            launchOnViewModelScope {
                this.wikiSearchRepository.loadWikiSearchResponse{
                    this.toastLiveData.postValue(it)
                }
            }
        }
    }

    fun fetchWikiSearchPageList() = this.wikiPageFetchingLiveData.postValue(true)

    fun insert(page : Page) = viewModelScope.launch {
        wikiSearchRepository.insert(page)
    }


}
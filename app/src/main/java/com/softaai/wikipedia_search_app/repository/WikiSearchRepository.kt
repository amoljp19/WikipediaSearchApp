package com.softaai.wikipedia_search_app.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import com.softaai.wikipedia_search_app.model.Page
import com.softaai.wikipedia_search_app.network.ApiResponse
import com.softaai.wikipedia_search_app.network.WikipediaApiClient
import com.softaai.wikipedia_search_app.network.message
import com.softaai.wikipedia_search_app.persistence.WikiSearchResponseDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WikiSearchRepository(private val wikipediaApiClient: WikipediaApiClient, private val wikiSearchResponseDao: WikiSearchResponseDao) {


    val allUsers: Flow<List<Page>> = wikiSearchResponseDao.getAllWikiPages()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(page: Page) {
        wikiSearchResponseDao.insert(page)
    }


    suspend fun loadWikiSearchResponse(error: (String) -> Unit) = withContext(Dispatchers.IO) {
        val liveData = MutableLiveData<List<Page>>()

        var allPages = wikiSearchResponseDao.getAllWikiPages().asLiveData().value

        if (allPages.isNullOrEmpty() == true) {
            wikipediaApiClient.fetchSearchData { response ->
                when (response) {
                    is ApiResponse.Success -> {
                        response.data.let {
                            allPages = it!!.query.pages
                            liveData.postValue(it.query.pages)
                            GlobalScope.launch{
                                wikiSearchResponseDao.insertPages(it.query.pages)
                            }
                        }
                    }
                    is ApiResponse.Failure.Error -> error(response.message())
                    is ApiResponse.Failure.Exception -> error(response.message())
                }
            }
        }
        liveData.apply { postValue(allPages) }
    }
}
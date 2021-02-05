package com.softaai.wikipedia_search_app.repository

import androidx.annotation.WorkerThread
import com.softaai.wikipedia_search_app.model.Page
import com.softaai.wikipedia_search_app.network.WikipediaApiClient
import com.softaai.wikipedia_search_app.persistence.WikiSearchResponseDao
import kotlinx.coroutines.flow.Flow

class WikiSearchRepository(private val wikipediaApiClient: WikipediaApiClient, private val wikiSearchResponseDao: WikiSearchResponseDao) {


    val allUsers: Flow<List<Page>> = wikiSearchResponseDao.getAllWikiPages()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(page: Page) {
        wikiSearchResponseDao.insert(page)
    }
}
package com.softaai.wikipedia_search_app.network

import com.softaai.wikipedia_search_app.model.WikiSearchResponse

class WikipediaApiClient (private val wikipediaApiService: WikipediaApiService) {

    fun fetchSearchData(onResult: (response: ApiResponse<WikiSearchResponse>) -> Unit) {
        this.wikipediaApiService.fetchSearchData().transform(onResult)
    }
}
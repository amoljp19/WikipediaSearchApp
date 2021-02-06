package com.softaai.wikipedia_search_app.network

import com.softaai.wikipedia_search_app.model.WikiSearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WikipediaApiService {

    @GET("/w/api.php")
    fun fetchSearchData(
        @Query("action") action:String = "query",
        @Query("formatversion") formatversion:String = "2",
        @Query("generator") generator:String = "prefixsearch",
        @Query("gpssearch") term: String = "kotlin",
        @Query("gpslimit") gpslimit: String = "10",
        @Query("gpsoffset") skip: String = "10",
        @Query("prop") prop:String = "pageimages|pageterms|info",
        @Query("piprop") piprop:String = "thumbnail|url",
        @Query("pithumbsize") pithumbsize:String = "50",
        @Query("pilimit") pilimit: String = "10",
        @Query("wbptterms") wbptterms:String = "description",
        @Query("format") format:String = "json",
        @Query("inprop") inprop:String = "url"
    ): Call<WikiSearchResponse>

}
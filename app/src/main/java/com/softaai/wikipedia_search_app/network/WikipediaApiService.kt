package com.softaai.wikipedia_search_app.network

import com.softaai.wikipedia_search_app.model.WikiSearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WikipediaApiService {

    @GET("/w/api.php")
    fun fetchSearchData(
        action:String = "query",
        formatVersion:String = "2",
        generator:String = "prefixsearch",
        @Query("gpssearch") term: String = "kotlin",
        @Query("gpslimit") gpslimit: String = "10",
        @Query("gpsoffset") skip: String = "",
        prop:String = "pageimages|info",
        piprop:String = "thumbnail|url",
        pithumbsize:String = "200",
        @Query("pilimit") pilimit: String = "10",
        wbptterms:String = "description",
        format:String = "json",
        inprop:String = "url"
    ): Call<WikiSearchResponse>

}
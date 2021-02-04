package com.softaai.wikipedia_search_app.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WikiSearchResponse(
    @Json(name = "batchcomplete")
    val batchcomplete: Boolean,
    @Json(name = "continue")
    val continueX: Continue,
    @Json(name = "query")
    val query: Query
)
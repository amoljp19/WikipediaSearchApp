package com.softaai.wikipedia_search_app.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Query(
    @Json(name = "pages")
    val pages: List<Page>,
    @Json(name = "redirects")
    val redirects: List<Redirect>?
)
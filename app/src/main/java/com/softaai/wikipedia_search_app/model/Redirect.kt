package com.softaai.wikipedia_search_app.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Redirect(
    @Json(name = "from")
    val from: String,
    @Json(name = "index")
    val index: Int,
    @Json(name = "to")
    val to: String
)
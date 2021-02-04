package com.softaai.wikipedia_search_app.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Thumbnail(
    @Json(name = "height")
    val height: Int,
    @Json(name = "source")
    val source: String,
    @Json(name = "width")
    val width: Int
)